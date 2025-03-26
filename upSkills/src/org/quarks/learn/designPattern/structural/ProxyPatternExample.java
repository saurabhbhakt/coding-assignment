package org.quarks.learn.designPattern.structural;
interface Image {
    void display();
}

class RealImage implements Image {
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadImageFromDisk();  // Simulate the expensive operation of loading the image
    }

    private void loadImageFromDisk() {
        System.out.println("Loading image: " + filename);
    }

    @Override
    public void display() {
        System.out.println("Displaying image: " + filename);
    }
}


class ProxyImage implements Image {
    private RealImage realImage;
    private String filename;

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(filename);  // Lazy loading (only load when needed)
        }
        realImage.display();  // Delegate the actual work to RealImage
    }
}

public class ProxyPatternExample {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("image1.jpg");
        Image image2 = new ProxyImage("image2.png");

        // Image will not be loaded from disk until it's displayed
        image1.display();

        // Image2 will be loaded only when it is displayed
        image2.display();

        // Image1 is already loaded, so it will be displayed directly
        image1.display();
    }
}

