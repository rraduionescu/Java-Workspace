package start;

import user_interface.Interface;
import com.bulenkov.darcula.DarculaLaf;

// Created by Ionescu Radu Stefan //

public class CarExpressAdministration
{
    public static void main(String args[])
    {
        try
        {
            javax.swing.UIManager.setLookAndFeel(new DarculaLaf());
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new Interface().setVisible(true);
            }
        });
    }
}
