package com.example.taher.listview;

/**
 * Created by Taher on 2/4/2019.
 */


public class book
{
    private class volumeInfo{

        private class industryIdentifiers{
            public String type ;
            public String identifier ;

        }

        private class readingModes{
            public boolean text;
            public boolean image;


        }

        private class imageLinks{
            public String smallThumbnail ;
            public String thumbnail;
        }


        public String title ;
        public String[] authors ;
        public String publisher ;
        public String publishedDate ;
        public String description ;
        public industryIdentifiers[] industryIdentifier ;
        public readingModes readingMode;
        public int pageCount ;
        public String printType ;
        public String[] categories ;
        public String maturityRating ;
        public boolean allowAnonLogging;
        public String contentVersion ;
        public imageLinks imageLink;
        public String language ;
        public String previewLink ;
        public String infoLink ;
        public String canonicalVolumeLink ;

    }



    private class saleInfo{
        public String country ;
        public String saleability ;
        public boolean isEbook;

    }


    private class accessInfo{
        public class epub{
            public boolean isAvailable;
        }
        private class pdf{
            public boolean isAvailable;
        }
        public String country ;
        public String viewability ;
        public boolean embeddable;
        public boolean publicDomain;
        public String textToSpeechPermission ;
        public pdf pdfitem;
        public epub epubitem;
        public String webReaderLink ;
        public String accessViewStatus ;
        public boolean quoteSharingAllowed;


    }


    private class searchInfo{
        public String textSnippet ;


    }


    private String kind ;
    private String id ;
    private String etag ;
    private String selfLink ;
    private volumeInfo volumeInfoitem;
    private saleInfo saleInfoitem;
    private accessInfo accessInfoitem;
    private searchInfo searchInfoitem;



























}
