package models;

import java.util.List;


public class Track extends TopItem {
        private Album album;
        private List<Artist> artists;
        private List<String> available_markets;
        private int disc_number;
        private int duration_ms;
        private boolean explicit;
        private ExternalIds external_ids;
        private ExternalUrls external_urls;
        private String href;
        private String id;
        private boolean is_playable;
        private String name;
        private int popularity;
        private String preview_url;
        private int track_number;
        private String type;
        private String uri;
        private boolean is_local;
        private Restrictions restrictions; 
        private int topNumber;
        
        
       

        // Getters and Setters
        public int getTopNumber() {
            return topNumber;
        }

        public void setTopNumber(int topNumber) {
            this.topNumber = topNumber;
        }
        
        public Restrictions getRestrictions() {
            return restrictions;
        }

        public void setRestrictions(Restrictions restrictions) {
            this.restrictions = restrictions;
        } 
        
        public Album getAlbum() {
            return album;
        }

        public void setAlbum(Album album) {
            this.album = album;
        }

        public List<Artist> getArtists() {
            return artists;
        }

        public void setArtists(List<Artist> artists) {
            this.artists = artists;
        }

        public List<String> getAvailable_markets() {
            return available_markets;
        }

        public void setAvailable_markets(List<String> available_markets) {
            this.available_markets = available_markets;
        }

        public int getDisc_number() {
            return disc_number;
        }

        public void setDisc_number(int disc_number) {
            this.disc_number = disc_number;
        }

        public int getDuration_ms() {
            return duration_ms;
        }

        public void setDuration_ms(int duration_ms) {
            this.duration_ms = duration_ms;
        }

        public boolean isExplicit() {
            return explicit;
        }

        public void setExplicit(boolean explicit) {
            this.explicit = explicit;
        }

        public ExternalIds getExternal_ids() {
            return external_ids;
        }

        public void setExternal_ids(ExternalIds external_ids) {
            this.external_ids = external_ids;
        }

        public ExternalUrls getExternal_urls() {
            return external_urls;
        }

        public void setExternal_urls(ExternalUrls external_urls) {
            this.external_urls = external_urls;
        }

        public String getHref() {
            return href;
        }

        public void setHref(String href) {
            this.href = href;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public boolean isIs_playable() {
            return is_playable;
        }

        public void setIs_playable(boolean is_playable) {
            this.is_playable = is_playable;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getPopularity() {
            return popularity;
        }

        public void setPopularity(int popularity) {
            this.popularity = popularity;
        }

        public String getPreview_url() {
            return preview_url;
        }

        public void setPreview_url(String preview_url) {
            this.preview_url = preview_url;
        }

        public int getTrack_number() {
            return track_number;
        }

        public void setTrack_number(int track_number) {
            this.track_number = track_number;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUri() {
            return uri;
        }

        public void setUri(String uri) {
            this.uri = uri;
        }

        public boolean isIs_local() {
            return is_local;
        }

        public void setIs_local(boolean is_local) {
            this.is_local = is_local;
        }
}
