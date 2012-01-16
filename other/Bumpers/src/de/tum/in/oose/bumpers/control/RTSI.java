package de.tum.in.oose.bumpers.control;

import java.io.File;
import java.io.IOException;
import java.net.JarURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;

/**
 * This utility class is looking for all the classes implementing or inheriting
 * from a given interface or class. (RunTime Subclass Identification)
 * 
 */
public class RTSI {

    /**
     * Display all the classes inheriting or implementing a given class in the
     * currently loaded packages.
     * 
     * @param tosubclassname
     *            the name of the class to inherit from
     * @return An array of objects inheriting or implementing a given class
     */
    @SuppressWarnings("unchecked")
    public static ArrayList<Object> find(String tosubclassname) {
        ArrayList<Object> ret = new ArrayList<Object>();
        try {
            Class<Object> tosubclass = (Class<Object>) Class
                    .forName(tosubclassname);
            Package[] pcks = Package.getPackages();
            for (int i = 0; i < pcks.length; i++) {
                ret.addAll(find(pcks[i].getName(), tosubclass));
            }
        } catch (ClassNotFoundException ex) {
            System.err.println("Class " + tosubclassname + " not found!");
        }
        return ret;
    }

    /**
     * Display all the classes inheriting or implementing a given class in a
     * given package.
     * 
     * @param pckgname
     *            the fully qualified name of the package
     * @param tosubclass
     *            the name of the class to inherit from
     * @return An array of objects inheriting or implementing a given class
     */
    @SuppressWarnings("unchecked")
    public static ArrayList<Object> find(String pckname, String tosubclassname) {
        ArrayList<Object> ret = new ArrayList<Object>();
        try {
            Class<Object> tosubclass = (Class<Object>) Class
                    .forName(tosubclassname);
            ret.addAll(find(pckname, tosubclass));
        } catch (ClassNotFoundException ex) {
            System.err.println("Class " + tosubclassname + " not found!");
        }
        return ret;
    }

    /**
     * Display all the classes inheriting or implementing a given class in a
     * given package.
     * 
     * @param pckgname
     *            the fully qualified name of the package
     * @param tosubclass
     *            the Class object to inherit from
     * @return An array of objects inheriting or implementing a given class
     */
    public static ArrayList<Object> find(String pckgname,
            Class<Object> tosubclass) {

        ArrayList<Object> ret = new ArrayList<Object>();
        // ======
        // Translate the package name into an absolute path
        String name = new String(pckgname);
        if (!name.startsWith("/")) {
            name = "/" + name;
        }
        name = name.replace('.', '/');

        // Get a File object for the package
        URL url = RTSI.class.getResource(name);
        // URL url = tosubclass.getResource(name);
        // URL url = ClassLoader.getSystemClassLoader().getResource(name);
        System.out.println(name + "->" + url);

        // Happens only if the jar file is not well constructed, i.e.
        // if the directories do not appear alone in the jar file like here:
        //
        // meta-inf/
        // meta-inf/manifest.mf
        // commands/ <== IMPORTANT
        // commands/Command.class
        // commands/DoorClose.class
        // commands/DoorLock.class
        // commands/DoorOpen.class
        // commands/LightOff.class
        // commands/LightOn.class
        // RTSI.class
        //
        if (url == null)
            return ret;

        File directory = new File(url.getFile());

        // New code
        // ======
        if (directory.exists()) {
            // Get the list of the files contained in the package
            String[] files = directory.list();
            for (int i = 0; i < files.length; i++) {

                // we are only interested in .class files
                if (files[i].endsWith(".class")) {
                    // removes the .class extension
                    String classname = files[i].substring(0,
                            files[i].length() - 6);
                    try {
                        // Try to create an instance of the object
                        Object o = Class.forName(pckgname + "." + classname)
                                .newInstance();
                        if (tosubclass.isInstance(o)) {
                            System.out.println(classname);
                            ret.add(o);
                        }
                    } catch (ClassNotFoundException cnfex) {
                        System.err.println(cnfex);
                    } catch (InstantiationException iex) {
                        // We try to instanciate an interface
                        // or an object that does not have a
                        // default constructor
                    } catch (IllegalAccessException iaex) {
                        // The class is not public
                    }
                }
            }
        } else {
            try {
                // It does not work with the filesystem: we must
                // be in the case of a package contained in a jar file.
                JarURLConnection conn = (JarURLConnection) url.openConnection();
                String starts = conn.getEntryName();
                JarFile jfile = conn.getJarFile();
                Enumeration<JarEntry> e = jfile.entries();
                while (e.hasMoreElements()) {
                    ZipEntry entry = (ZipEntry) e.nextElement();
                    String entryname = entry.getName();
                    if (entryname.startsWith(starts)
                            && (entryname.lastIndexOf('/') <= starts.length())
                            && entryname.endsWith(".class")) {
                        String classname = entryname.substring(0, entryname
                                .length() - 6);
                        if (classname.startsWith("/"))
                            classname = classname.substring(1);
                        classname = classname.replace('/', '.');
                        try {
                            // Try to create an instance of the object
                            Object o = Class.forName(classname).newInstance();
                            if (tosubclass.isInstance(o)) {
                                System.out
                                        .println(classname.substring(classname
                                                .lastIndexOf('.') + 1));
                                ret.add(o);
                            }
                        } catch (ClassNotFoundException cnfex) {
                            System.err.println(cnfex);
                        } catch (InstantiationException iex) {
                            // We try to instanciate an interface
                            // or an object that does not have a
                            // default constructor
                        } catch (IllegalAccessException iaex) {
                            // The class is not public
                        }
                    }
                }
            } catch (IOException ioex) {
                System.err.println(ioex);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        if (args.length == 2) {
            find(args[0], args[1]);
        } else {
            if (args.length == 1) {
                find(args[0]);
            } else {
                System.out.println("Usage: java RTSI [<package>] <subclass>");
            }
        }
    }
}
