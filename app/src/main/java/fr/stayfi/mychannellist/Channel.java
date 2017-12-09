package fr.stayfi.mychannellist;

/**
 * Created by Stayfi on 06/12/2017.
 */

public class Channel {
    private String name;
    private String picon;
    private String URI;

    public Channel() {
        this.setName("");
        this.setPicon("");
        this.setURI("");
    }

    public Channel(String name, String picon, String URI) {
        this.setName(name);
        this.setPicon(picon);
        this.setURI(URI);
    }

    public String getName() {
        return name;
    }

    public String getPicon() {
        return picon;
    }

    public String getURI() {
        return URI;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPicon(String picon) {
        this.picon = picon;
    }

    public void setURI(String URI) {
        this.URI = URI;
    }
}
