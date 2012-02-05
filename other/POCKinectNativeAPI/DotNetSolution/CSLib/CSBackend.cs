using System;
using System.Runtime.InteropServices;
using System.Text;

public class CSharp
{
    [UnmanagedFunctionPointer(CallingConvention.StdCall)]
    delegate void CFuncDelegate(IntPtr Obj, IntPtr Arg, [MarshalAs(UnmanagedType.LPStr)] string str);

    public static void Function(IntPtr CFunc, IntPtr Obj, IntPtr Arg, String[] pUnmanagedStringArray)
    {
        CFuncDelegate func = (CFuncDelegate)Marshal.GetDelegateForFunctionPointer(CFunc, typeof(CFuncDelegate));

        Console.WriteLine("[C#]Marshalling Arguments in C#");
        for (int i = 0; i < pUnmanagedStringArray.Length; i++)
        {
            Console.WriteLine("[C#]" + pUnmanagedStringArray[i]);
        }
        string str = "Reply String from C#";
        func.Invoke(Obj, Arg, str);
    }
}