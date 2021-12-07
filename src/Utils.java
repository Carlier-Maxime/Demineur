import java.awt.*;

public final class Utils {
    public static GridBagConstraints gridBagConstraints(){
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1;
        c.weighty = 1;
        return c;
    }
}
