using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Windows;
using System.Windows.Input;
using System.Xml;
using System.Threading;

using Microsoft.Research.Kinect.Nui;


namespace MicrosoftKinectWrapper
{
    public interface IKinectHandler
    {
        string setUpAndRun();
        string testSkeletonTracking();
        string getSkeleton();
    }

    public class KinectHandler : IKinectHandler
    {
        private Runtime nui;
        private List<string> skeletonQueue = new List<string>();
        private bool skeletonQueueBusy = false;

        //private ClientConnectionHandler cch;

        public KinectHandler()
        {
        }

        public string getSkeleton()
        {
            /* Busy waiting */
            while (skeletonQueueBusy)
            {
                Thread.Sleep(50);
            }

            skeletonQueueBusy = true;
            List<string> skeletonList = new List<string>();
            while (skeletonQueue.Count > 0)
            {
                skeletonList.Add(skeletonQueue.ElementAt(0));
                skeletonQueue.RemoveAt(0);
            }

            skeletonQueueBusy = false;

            string listToString = null;
            if (skeletonList.Count > 0)
            {
                listToString = skeletonList.ElementAt(0);
                for (int i = 1; i < skeletonList.Count; i++)
                {
                    listToString += "*" + skeletonList.ElementAt(i);
                }
            }
            
            return (null != listToString) ? listToString : null;
        }


        private void appendSkeletonToQueue(string skeleton)
        {
            /* Busy waiting */
            while (skeletonQueueBusy)
            {
                Thread.Sleep(50);
            }

            skeletonQueueBusy = true;
            skeletonQueue.Add(skeleton);
            skeletonQueueBusy = false;
        }


        private void nui_SkeletonFrameReady(object sender, SkeletonFrameReadyEventArgs e)
        {
            SkeletonFrame skeletonFrame = e.SkeletonFrame;

            Vector normalToGravity = skeletonFrame.NormalToGravity;

            XmlDocument doc = new XmlDocument();

            XmlNode xmlnode = doc.CreateNode(XmlNodeType.XmlDeclaration, "", "");
            doc.AppendChild(xmlnode);

            XmlNode root = doc.CreateElement("Skeleton");
            doc.AppendChild(root);

            XmlNode frameNode = doc.CreateElement("frameNumber");
            frameNode.InnerText = skeletonFrame.FrameNumber.ToString();
            root.AppendChild(frameNode);

            XmlNode timeStampNode = doc.CreateElement("timeStamp");
            timeStampNode.InnerText = skeletonFrame.TimeStamp.ToString();
            root.AppendChild(timeStampNode);


            foreach (SkeletonData data in skeletonFrame.Skeletons)
            {

                if (data.TrackingState == SkeletonTrackingState.Tracked)
                {
                    XmlNode skeletonData = doc.CreateElement("skeletonData");
                    root.AppendChild(skeletonData);

                    XmlNode trackingId = doc.CreateElement("trackingId");
                    trackingId.InnerText = data.TrackingID.ToString();
                    skeletonData.AppendChild(trackingId);

                    XmlNode userIndex = doc.CreateElement("userIndex");
                    userIndex.InnerText = data.UserIndex.ToString();
                    skeletonData.AppendChild(userIndex);

                    JointsCollection joints = data.Joints;

                    foreach (Joint j in joints)
                    {
                        XmlNode joint = doc.CreateElement("joint");

                        XmlNode jPositionX = doc.CreateElement("positionX");
                        jPositionX.InnerText = j.Position.X.ToString();
                        joint.AppendChild(jPositionX);

                        XmlNode jPositionY = doc.CreateElement("positionY");
                        jPositionY.InnerText = j.Position.Y.ToString();
                        joint.AppendChild(jPositionY);

                        XmlNode jPositionZ = doc.CreateElement("positionZ");
                        jPositionZ.InnerText = j.Position.Z.ToString();
                        joint.AppendChild(jPositionZ);

                        XmlNode jointID = doc.CreateElement("jointId");
                        jointID.InnerText = j.ID.ToString();
                        joint.AppendChild(jointID);

                        skeletonData.AppendChild(joint);
                    }

                    XmlNode positionX = doc.CreateElement("positionX");
                    positionX.InnerText = data.Position.X.ToString();
                    skeletonData.AppendChild(positionX);

                    XmlNode positionY = doc.CreateElement("positionY");
                    positionY.InnerText = data.Position.Y.ToString();
                    skeletonData.AppendChild(positionY);

                    XmlNode positionZ = doc.CreateElement("positionZ");
                    positionZ.InnerText = data.Position.Z.ToString();
                    skeletonData.AppendChild(positionZ);

                }

                appendSkeletonToQueue(doc.OuterXml);
                //cch.sendSkeleton(doc.OuterXml);
            }
        }

        internal void startSkeletonTracking()
        {
        }

        public string setUpAndRun()
        {
            nui = Runtime.Kinects[0];

            try
            {
                nui.Initialize(RuntimeOptions.UseDepthAndPlayerIndex | RuntimeOptions.UseSkeletalTracking);

            }
            catch (InvalidOperationException)
            {
                return "Runtime initialization failed. Please make sure Kinect device is plugged in.";
            }

            try
            {
                nui.DepthStream.Open(ImageStreamType.Depth, 2, ImageResolution.Resolution320x240, ImageType.DepthAndPlayerIndex);

            }
            catch (InvalidOperationException e)
            {
                return "Failed to open stream. Please make sure to specify a supported image type and resolution." + e.Message;
            }
            nui.SkeletonFrameReady += new EventHandler<SkeletonFrameReadyEventArgs>(nui_SkeletonFrameReady);

            return "Setup Done!";

        }

        public string testSkeletonTracking()
        {


            XmlDocument doc = new XmlDocument();

            XmlNode xmlnode = doc.CreateNode(XmlNodeType.XmlDeclaration, "", "");
            doc.AppendChild(xmlnode);

            XmlNode root = doc.CreateElement("Skeleton");
            doc.AppendChild(root);

            XmlNode frameNode = doc.CreateElement("frameNumber");
            frameNode.InnerText = "frameNumber";
            root.AppendChild(frameNode);

            XmlNode timeStampNode = doc.CreateElement("timeStamp");
            timeStampNode.InnerText = "timeStamp";
            root.AppendChild(timeStampNode);


            for (int i = 0; i < 2; i++)
            {

                if (true)
                {
                    XmlNode skeletonData = doc.CreateElement("skeletonData");
                    root.AppendChild(skeletonData);

                    XmlNode trackingId = doc.CreateElement("trackingId");
                    trackingId.InnerText = "trackingId" + i;
                    skeletonData.AppendChild(trackingId);

                    XmlNode userIndex = doc.CreateElement("userIndex");
                    userIndex.InnerText = "userIndex" + i;
                    skeletonData.AppendChild(userIndex);



                    for (int j = 0; j < 2; j++)
                    {
                        XmlNode joint = doc.CreateElement("joint");

                        XmlNode jPositionX = doc.CreateElement("positionX");
                        jPositionX.InnerText = "positionX" + i + j;
                        joint.AppendChild(jPositionX);

                        XmlNode jPositionY = doc.CreateElement("positionY");
                        jPositionY.InnerText = "positionY" + i + j;
                        joint.AppendChild(jPositionY);

                        XmlNode jPositionZ = doc.CreateElement("positionZ");
                        jPositionZ.InnerText = "positionZ" + i + j;
                        joint.AppendChild(jPositionZ);

                        XmlNode jointID = doc.CreateElement("jointId");
                        jointID.InnerText = "jointId " + i + j;
                        joint.AppendChild(jointID);
                    }

                    XmlNode positionX = doc.CreateElement("positionX");
                    positionX.InnerText = "positionX" + i;
                    skeletonData.AppendChild(positionX);

                    XmlNode positionY = doc.CreateElement("positionY");
                    positionY.InnerText = "positionY" + i;
                    skeletonData.AppendChild(positionY);

                    XmlNode positionZ = doc.CreateElement("positionZ");
                    positionZ.InnerText = "positionZ" + i;
                    skeletonData.AppendChild(positionZ);

                }
            }

            return "SKELETON: " + doc.OuterXml;

            //cch.sendSkeleton("SKELETON: " + doc.OuterXml);
        }
    }
}
