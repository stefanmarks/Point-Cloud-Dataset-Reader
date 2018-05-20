package nz.ac.aut.SentienceLab.PointCloudDatasetReader;

import java.util.prefs.Preferences;

/**
 * Class for managing the last settings and storing/restoring them
 * 
 * @author  Stefan Marks
 * @version 1.0 - 21.05.2018: Created
 */
public class Settings 
{
    public Settings()
    {
        preferences = Preferences.userNodeForPackage(this.getClass());
    }
    
    private final String KEY_SRC_FILE  = "SourceFilename";
    private final String KEY_SRC_CSYS  = "SourceCoordinateSystem";
    private final String KEY_DST_FILE  = "DestinationFilename";
    private final String KEY_DST_CSYS  = "DestinationCoordinateSystem";
    private final String KEY_RANDOMISE = "Randomise";
    
	
    public String getSourceFile()
    {
        return preferences.get(KEY_SRC_FILE, ".input.csv");
    }
    
    public void setSourceFile(String name)
    {
        preferences.put(KEY_SRC_FILE, name);
    }
    
	
    public CoordinateSystem getSourceCSys()
    {
        String csys = preferences.get(KEY_SRC_CSYS, CoordinateSystem.XR_YU_ZF.toString());
        return CoordinateSystem.fromString(csys);
    }
    
    public void setSourceCSys(CoordinateSystem csys)
    {
        preferences.put(KEY_SRC_CSYS, csys.toString());
    }
    
	
    public String getDestinationFile()
    {
        return preferences.get(KEY_DST_FILE, "output.bytes");
    }
    
    public void setDestinationFile(String name)
    {
        preferences.put(KEY_DST_FILE, name);
    }
    
	
    public CoordinateSystem getDestinationCSys()
    {
        String csys = preferences.get(KEY_DST_CSYS, CoordinateSystem.XR_YU_ZF.toString());
        return CoordinateSystem.fromString(csys);
    }
    
    public void setDestinationCSys(CoordinateSystem csys)
    {
        preferences.put(KEY_DST_CSYS, csys.toString());
    }
    

    public boolean getRandomiseFlag()
    {
        return preferences.getBoolean(KEY_RANDOMISE, false);
    }
    
    public void setRandomiseFlag(boolean randomise)
    {
        preferences.putBoolean(KEY_RANDOMISE, randomise);
    }
    

    private final Preferences preferences;
}
