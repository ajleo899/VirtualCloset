package com.example.virtualcloset;

import android.media.Image;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Closet class is a class that interacts with all articles of clothing and outfits on the app.
 * A single Closet object is made that keeps track of all user's clothes etc.
 * It also keeps track of which articles of clothing are currently presented on the closet screen.
 */
public class Closet implements Serializable {

    private ClothingArticle activeTop;
    private ClothingArticle activeBottom;
    private ClothingArticle activeShoe;
    private ArrayList<ClothingArticle> allClothes;
    private ArrayList<Outfit> allOutfits;

    public Closet() {
        activeTop = null;
        activeBottom = null;
        activeShoe = null;
        allClothes = new ArrayList<>();
        allOutfits = new ArrayList<>();
    }

    public Closet(ClothingArticle activeTop, ClothingArticle activeBottom, ClothingArticle activeShoe, ArrayList<ClothingArticle> allClothes, ArrayList<Outfit> allOutfits) {
        this.activeTop = activeTop;
        this.activeBottom = activeBottom;
        this.activeShoe = activeShoe;
        this.allClothes = allClothes;
        this.allOutfits = allOutfits;
    }

    public ClothingArticle getActiveTop() {
        return activeTop;
    }

    public void setActiveTop(ClothingArticle c) {
        activeTop = c;
    }

    public ClothingArticle getActiveBottom() {
        return activeBottom;
    }

    public void setActiveBottom(ClothingArticle c) {
        activeBottom = c;
    }

    public ClothingArticle getActiveShoe() {
        return activeTop;
    }

    public void setActiveShoe(ClothingArticle c) {
        activeShoe = c;
    }

    public ArrayList<ClothingArticle> getAllClothes() {
        return allClothes;
    }

    public void addClothing(ClothingArticle c) {
        allClothes.add(c);
    }

    public ArrayList<Outfit> getAllOutfits() {
        return allOutfits;
    }

    public void addOutfit(Outfit o) {
        allOutfits.add(o);
    }

    public ArrayList<ClothingArticle> getAllTops() {
        ArrayList<ClothingArticle> tops = new ArrayList<>();
        for(ClothingArticle c : allClothes) {
            if(c.getType().equals("top"))
                tops.add(c);
        }
        return tops;
    }

    public ArrayList<ClothingArticle> getAllBottoms() {
        ArrayList<ClothingArticle> bottoms = new ArrayList<>();
        for(ClothingArticle c : allClothes) {
            if(c.getType().equals("bottom"))
                bottoms.add(c);
        }
        return bottoms;
    }

    public ArrayList<ClothingArticle> getAllShoes() {
        ArrayList<ClothingArticle> shoes = new ArrayList<>();
        for(ClothingArticle c : allClothes) {
            if(c.getType().equals("shoe"))
                shoes.add(c);
        }
        return shoes;
    }

    public ArrayList<Outfit> getSummerOutfits() {
        ArrayList<Outfit> summerOutfits = new ArrayList<>();
        for(Outfit o : allOutfits) {
            if(o.getCollection().equals("summer"))
                summerOutfits.add(o);
        }
        return summerOutfits;
    }

    public ArrayList<Outfit> getFallOutfits() {
        ArrayList<Outfit> fallOutfits = new ArrayList<>();
        for(Outfit o : allOutfits) {
            if(o.getCollection().equals("fall"))
                fallOutfits.add(o);
        }
        return fallOutfits;
    }

    public ArrayList<Outfit> getWinterOutfits() {
        ArrayList<Outfit> winterOutfits = new ArrayList<>();
        for(Outfit o : allOutfits) {
            if(o.getCollection().equals("winter"))
                winterOutfits.add(o);
        }
        return getWinterOutfits();
    }

    public ArrayList<Outfit> getSpringOutfits() {
        ArrayList<Outfit> springOutfits = new ArrayList<>();
        for(Outfit o : allOutfits) {
            if(o.getCollection().equals("spring"))
                springOutfits.add(o);
        }
        return springOutfits;
    }


    /**
     * Clothing Article class defines each article of clothing, whether top, bottom, or shoe.
     * Each article has an associated user-specified String name, Image image, String type, and
     * String color.
     */
    class ClothingArticle implements Serializable{

        private String name;
        private Image image;
        private String type;
        private String color;

        public ClothingArticle() {
            name = "";
            image = null;
            type = "";
            color = "";
        }

        public ClothingArticle(String n, Image i, String t, String c) {
            name = n;
            image = i;
            type = t;
            color = c;
        }

        public String getName() {
            return name;
        }

        public void setName(String s) {
            name = s;
        }

        public Image getImage() {
            return image;
        }

        public void setImage(Image i) {
            image = i;
        }

        // VALID TYPES: "top" "bottom" "shoe"
        public String getType() {
            return type;
        }

        public void setType(String t) {
            type = t;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String c) {
            color = c;
        }

    }


    /**
     * Outfit class defines all outfits in the closet. Each outfit has an associated top, bottom, and shoe.
     * Each outfit also has a favorite flag denoting if it is a user favorite. Outfits also belong to collections,
     * so they have a String collections specifier denoting whether they belong to summer, fall, winter, or spring.
     */
    class Outfit implements Serializable{

        private ClothingArticle top;
        private ClothingArticle bottom;
        private ClothingArticle shoe;
        private boolean isFavorite;
        private String collection;


        public Outfit() {
            top = null;
            bottom = null;
            shoe = null;
            isFavorite = false;
            collection = "";
        }

        public Outfit(ClothingArticle top, ClothingArticle bottom, ClothingArticle shoe, boolean isFavorite, String collection) {
            this.top = top;
            this.bottom = bottom;
            this.shoe = shoe;
            this.isFavorite = isFavorite;
            this.collection = collection;
        }

        public ClothingArticle getTop() {
            return top;
        }

        public void setTop(ClothingArticle top) {
            this.top = top;
        }

        public ClothingArticle getBottom() {
            return bottom;
        }

        public void setBottom(ClothingArticle bottom) {
            this.bottom = bottom;
        }

        public ClothingArticle getShoe() {
            return shoe;
        }

        public void setShoe(ClothingArticle shoe) {
            this.shoe = shoe;
        }

        public boolean isFavorite() {
            return isFavorite;
        }

        public void setFavorite(boolean b) {
            isFavorite = b;
        }

        // VALID INPUTS: "summer" "fall" "winter" "spring"
        public String getCollection() {
            return collection;
        }

        public void setCollection(String c) {
            collection = c;
        }
    }


}
