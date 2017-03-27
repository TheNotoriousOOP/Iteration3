import model.map.editor.EditorMap;
import model.utilities.FileUtilities;
import org.junit.Test;

/**
 * Created by TheNotoriousOOP on 3/26/2017.
 */
public class LoadMapTest {

    @Test
    public void testLoad() {
        //TODO figure out map path to load from
        String[] lines = FileUtilities.loadMap("src/res/mapfiles/TestMap.txt");
        EditorMap testMap = new EditorMap();
        testMap.load(lines);
        assert lines.length > 0;
        assert testMap.hasThisManyTiles(lines.length -1);
    }
}
