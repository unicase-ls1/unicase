using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace KinectUser
{
    class Program
    {
        static void Main(string[] args)
        {
            MicrosoftKinectWrapper.IKinectHandler kinectHandler = new MicrosoftKinectWrapper.KinectHandler();
            kinectHandler.setUpAndRun();
            while (true)
                ;
        }
    }
}
