package ISP;

interface AudioPlayer {
 void playAudio(String fileName);
}

interface VideoPlayer {
 void playVideo(String fileName);
}

interface AudioRecorder {
 void recordAudio(String fileName);
}

interface VideoRecorder {
 void recordVideo(String fileName);
}

class BasicAudioPlayer implements AudioPlayer {
 public void playAudio(String fileName) {
     System.out.println("Memutar audio: " + fileName);
 }
}