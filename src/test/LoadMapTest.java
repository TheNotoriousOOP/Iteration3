import model.map.editor.EditorMap;
import model.utilities.FileUtilities;
import org.junit.Test;

/**
 * Created by Jonathen on 3/26/2017.
 */
public class LoadMapTest {

    @Test
    public void testLoad() {
        //TODO figure out map path to load from
        String[] arrayOfFileLines = FileUtilities.loadMap("res/mapfiles/TestMap.txt");
        EditorMap testMap = new EditorMap(15);
        testMap.load(arrayOfFileLines);
        /*assert arrayOfFileLines.length > 0;
        assert testMap.hasThisManyTiles(arrayOfFileLines.length -1);*/
    }
}
