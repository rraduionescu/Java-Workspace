/*/
 * @author Radu Ionescu
/*/
package MyClasses;

import java.io.File;
import javax.swing.filechooser.FileFilter;

public class PBDFilter extends FileFilter
    {
    public boolean accept(File f) 
        {
        boolean i=true;
        String extension = f.toString().substring(f.toString().length()-4,f.toString().length());
        if(f.toString().endsWith(extension)||f.isDirectory())return true;
        return false;
        }
    public String getDescription() 
        {
        return "Power Book Database (.pbd)";
        }
    }
