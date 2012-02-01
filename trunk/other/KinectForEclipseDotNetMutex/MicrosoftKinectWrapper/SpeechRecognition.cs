/////////////////////////////////////////////////////////////////////////
//
// This module provides sample code used to demonstrate the use
// of the KinectAudioSource for speech recognition
//
// Copyright © Microsoft Corporation.  All rights reserved.  
// This code is licensed under the terms of the 
// Microsoft Kinect for Windows SDK (Beta) from Microsoft Research 
// License Agreement: http://research.microsoft.com/KinectSDK-ToU
//
/////////////////////////////////////////////////////////////////////////

/*
 * IMPORTANT: This sample requires the following components to be installed:
 * 
 * Speech Platform Runtime (v10.2) x86. Even on x64 platforms the x86 needs to be used because the MSR Kinect SDK runtime is x86
 * http://www.microsoft.com/downloads/en/details.aspx?FamilyID=bb0f72cb-b86b-46d1-bf06-665895a313c7
 * 
 * Kinect English Language Pack: MSKinectLangPack_enUS.msi (available in the same location as the Kinect For
 * Windows SDK)
 *
 * Speech Platform SDK (v10.2) 
 * http://www.microsoft.com/downloads/en/details.aspx?FamilyID=1b1604d3-4f66-4241-9a21-90a294a5c9a4&displaylang=en
 * */

using System;
using System.IO;
using System.Linq;
using Microsoft.Research.Kinect.Audio;
using Microsoft.Speech.AudioFormat;
using Microsoft.Speech.Recognition;
using System.Threading;
using System.Collections.Generic;


namespace MicrosoftKinectWrapper
{
    public interface ISpeechRecognition
    {
        void setup(string[] args);
        void startRecog();
        string getSpeech();
    }

    public class SpeechRecognition : ISpeechRecognition
    {
        private const string RecognizerId = "SR_MS_en-US_Kinect_10.0";
        private SpeechRecognitionEngine sre;
        //private StreamWriter output;
        private Stream s;
        private GrammarBuilder gb;
        private Grammar g;
        private KinectAudioSource source;
        private bool speechQueueBusy = false;
        private List<string> speechQueue = new List<string>();

        public void setup(string[] args/*, StreamWriter writer*/)
        {
            //output = writer;
            source = new KinectAudioSource();

            source.FeatureMode = true;
            source.AutomaticGainControl = false; //Important to turn this off for speech recognition
            source.SystemMode = SystemMode.OptibeamArrayOnly; //No AEC for this sample

            RecognizerInfo ri = SpeechRecognitionEngine.InstalledRecognizers().Where(r => r.Id == RecognizerId).FirstOrDefault();

            if (ri == null)
            {
                Console.WriteLine("Could not find speech recognizer: {0}. Please refer to the sample requirements.", RecognizerId);
                return;
            }

            Console.WriteLine("Using: {0}", ri.Name);

            //using (var sre = new SpeechRecognitionEngine(ri.Id))
            sre = new SpeechRecognitionEngine(ri.Id);
            var words = new Choices();
            foreach (string w in args)
            {
                words.Add(w);
            }

            gb = new GrammarBuilder();
            //Specify the culture to match the recognizer in case we are running in a different culture.                                 
            gb.Culture = ri.Culture;
            gb.Append(words);


            // Create the actual Grammar instance, and then load it into the speech recognizer.
            g = new Grammar(gb);

            sre.LoadGrammar(g);
            sre.SpeechRecognized += SreSpeechRecognized;
            sre.SpeechHypothesized += SreSpeechHypothesized;
            sre.SpeechRecognitionRejected += SreSpeechRecognitionRejected;

            s = source.Start();

            sre.SetInputToAudioStream(s,
                                      new SpeechAudioFormatInfo(
                                          EncodingFormat.Pcm, 16000, 16, 1,
                                          32000, 2, null));

            Console.Write("Recognizing: ");
            foreach (string w in args)
            {
                Console.Write(w + " ");
            }
            Console.Write("\n");

            startRecog();

        }

        public string getSpeech()
        {
            /* Busy waiting */
            while (speechQueueBusy)
            {
                Thread.Sleep(50);
            }

            speechQueueBusy = true;
            List<string> speechList = new List<string>();
            while (speechQueue.Count > 0)
            {
                speechList.Add(speechQueue.ElementAt(0));
                speechQueue.RemoveAt(0);
            }

            speechQueueBusy = false;

            string listToString = null;
            if (speechList.Count > 0)
            {
                listToString = speechList.ElementAt(0);
                for (int i = 1; i < speechList.Count; i++)
                {
                    listToString += "*" + speechList.ElementAt(i);
                }
            }

            return (null != listToString) ? listToString : null;
        }


        private void appendSpeechToQueue(string speech)
        {
            /* Busy waiting */
            while (speechQueueBusy)
            {
                Thread.Sleep(50);
            }

            speechQueueBusy = true;
            speechQueue.Add(speech);
            speechQueueBusy = false;
        }

        public void startRecog()
        {
            sre.RecognizeAsync(RecognizeMode.Multiple);
        }

        public void stop()
        {
            Console.WriteLine("Stopping recognizer ...");
            sre.RecognizeAsyncCancel();
        }

        private void SreSpeechRecognitionRejected(object sender, SpeechRecognitionRejectedEventArgs e)
        {
            Console.WriteLine("\nSpeech Rejected");
        }

        private void SreSpeechHypothesized(object sender, SpeechHypothesizedEventArgs e)
        {
            Console.Write("\rSpeech Hypothesized: \t{0}", e.Result.Text);
        }

        private void SreSpeechRecognized(object sender, SpeechRecognizedEventArgs e)
        {
            //This first release of the Kinect language pack doesn't have a reliable confidence model, so 
            //we don't use e.Result.Confidence here.
            Console.WriteLine("\nSpeech Recognized: \t{0}", e.Result.Text);
            //output.WriteLine("RECOGNIZED: " + e.Result.Text);
            appendSpeechToQueue("RECOGNIZED: " + e.Result.Text);
        }

    }
}
