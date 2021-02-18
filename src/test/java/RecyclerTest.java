import org.testng.annotations.Test;

public class RecyclerTest extends TestBase{
    @Test
    public void testHorizontalSwipe() {

        app.recycler().selectItemSwipe();
        app.recycler().selectDraggableBase();
    }
    @Test
    public void testDragNDrop() {
        app.recycler().selectDraggableBase();
    }
}
