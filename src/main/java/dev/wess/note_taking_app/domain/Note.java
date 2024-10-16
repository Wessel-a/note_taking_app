package dev.wess.note_taking_app.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String text;

    @OneToMany
    @JoinColumn(name = "note_id")
    private List<Image> images = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "note_id")
    private List<Sketch> sketches = new ArrayList<>();




    public void addImage(Image image) {
        images.add(image);
    }
    public void addSketch(Sketch sketch) {
        sketches.add(sketch);
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public List<Image> getImages() {
        return images;
    }
    public void setImages(List<Image> images) {
        this.images = images;
    }
    public List<Sketch> getSketches() {
        return sketches;
    }
    public void setSketches(List<Sketch> sketches) {
        this.sketches = sketches;
    }
}
