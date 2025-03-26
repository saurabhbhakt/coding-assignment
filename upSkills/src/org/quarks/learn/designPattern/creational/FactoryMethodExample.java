package org.quarks.learn.designPattern.creational;


interface Document {
    void displayContent();
}

class PDFDocument implements Document {
    @Override
    public void displayContent() {
        System.out.println("Displaying PDF document content...");
    }
}

class WordDocument implements Document {
    @Override
    public void displayContent() {
        System.out.println("Displaying Word document content...");
    }
}

class DocumentFactory {
    // Factory Method to create the product (Document)
    public Document createDocument(String docType){
        if(docType.equals("pdf")){
            return new PDFDocument();
        } else if (docType.equals("word")) {
            return new WordDocument();
        }
        return null;
    }

    // This method is used to display the document
    public void openDocument(Document document) {
        document.displayContent();
    }
}


public class FactoryMethodExample {
    public static void main(String[] args) {
        // Create the factory for PDF documents
        DocumentFactory pdfFactory = new DocumentFactory();
        Document pdfDoc = pdfFactory.createDocument("pdf");  // It will create a PDF document
        pdfFactory.openDocument(pdfDoc);

        // Create the factory for Word documents
        DocumentFactory wordFactory = new DocumentFactory();
        Document wordDoc = wordFactory.createDocument("word");  // It will create a WORD document
        wordFactory.openDocument(pdfDoc);
    }
}




