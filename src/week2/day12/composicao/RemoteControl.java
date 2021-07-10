package week2.day12.composicao;

public class RemoteControl {

    TV tv;

    RemoteControl(TV tv) {
        this.tv = tv;
    }

    void incrementVolume() {
        this.tv.incrementVolume();
    }

    void decrementVolume() {
        this.tv.decrementVolume();
    }

    void incrementChannel() {
        this.tv.incrementChannel();
    }

    void decrementChannel() {
        this.tv.decrementChannel();
    }

    void setChannel(int canal) {
        this.tv.setChannel(canal);
    }

    void showVolumeAndChannel() {
        this.tv.showVolumeAndChannel();
    }
}
