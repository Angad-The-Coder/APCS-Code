import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.UnsupportedAudioFileException;

public class SoundPlayer {
    ArrayList<Clip> clipList;// this is the Clip that will be played
    ArrayList<String> fileList;
    static ArrayList<AudioInputStream> cachedSounds = new ArrayList<AudioInputStream>();

    public SoundPlayer() {
        clipList = new ArrayList<Clip>();
        fileList = new ArrayList<String>();
    }

    public void loadFiles() {
        loadFiles(fileList);
    }

    public void loadFiles(ArrayList<String> fileList) {
        for (String fn : fileList) {
            try {
                AudioInputStream reusableAudioInputStream =
                        createReusableAudioInputStream(new File(fn));
                cachedSounds.add(reusableAudioInputStream);
            } catch (Exception e) {
                System.out.println("Problem with sound loading \n" + e);
            }
        }
    }

    public void play(int i) {
        try {
            AudioInputStream stream = cachedSounds.get(i);
            stream.reset();
            Clip clip = AudioSystem.getClip();
            clip.open(stream);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static AudioInputStream createReusableAudioInputStream(File file)
            throws IOException, UnsupportedAudioFileException {
        AudioInputStream ais = null;
        try {
            ais = AudioSystem.getAudioInputStream(file);
            byte[] buffer = new byte[1024 * 32];
            int read = 0;
            ByteArrayOutputStream baos = new ByteArrayOutputStream(buffer.length);
            while ((read = ais.read(buffer, 0, buffer.length)) != -1) {
                baos.write(buffer, 0, read);
            }
            AudioInputStream reusableAis =
                    new AudioInputStream(new ByteArrayInputStream(baos.toByteArray()),
                            ais.getFormat(), AudioSystem.NOT_SPECIFIED);
            return reusableAis;
        } finally {
            if (ais != null) {
                ais.close();
            }
        }
    }
}
