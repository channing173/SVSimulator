
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SVGUI
{

  private JFrame frame;
  private JPanel panel;
  private JButton button;
  private ImageIcon icon;
  private JLabel thumb;

  public SVGUI()
  {
    
    icon = new ImageIcon("background.jpg");
    thumb = new JLabel();
    thumb.setIcon(icon);
    
    frame = new JFrame("S U I C I D A L  V I B E S");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setBackground(Color.BLACK);

    AListener l = new AListener();

    panel = new JPanel();
    button = new JButton("Suicidal Vibes");
    button.addActionListener(l);

    
    panel.add(button);
    panel.add(thumb);
    thumb.setVisible(false);

    frame.add(panel);

  }

  public void display()
  {

    panel.setBackground(Color.BLACK);
    button.setBackground(Color.WHITE);
    frame.setSize(1200, 675);
    frame.setVisible(true);

  }

  private class AListener implements ActionListener
  {

    @Override
    public void actionPerformed(ActionEvent e)
    {

      if (e.getSource().equals(button))
      {
        
        panel.remove(button);
        thumb.setVisible(true);

        try
        {
          File soundFile = new File("Suicidal_Vibes_Updated.wav");
          AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
          Clip clip = AudioSystem.getClip();
          clip.open(audioIn);
          clip.start();
          
        }
        catch (UnsupportedAudioFileException e1)
        {
          e1.printStackTrace();
        }
        catch (IOException e2)
        {
          e2.printStackTrace();
        }
        catch (LineUnavailableException e3)
        {
          e3.printStackTrace();
        }

      }

    }

  }

}
