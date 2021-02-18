import org.testng.annotations.Test;

public class RecyclerTest extends TestBase{
    @Test
    public void testHorizontalSwipe() {

        app.recycler().selectItemSwipe();
        app.recycler().selectDraggableBase();
       app.recycler().swipeFormeRightToTeft();
      //  app.recycler().swipeFormeRightToRight();
    }
    @Test
    public void testDragNDrop() {

        app.recycler().selectDraggableBase();
     //  app.recycler().dragDown();
        app.recycler().dragDownCount(4);
      //  app.recycler().dragDownWin();

    }
}
