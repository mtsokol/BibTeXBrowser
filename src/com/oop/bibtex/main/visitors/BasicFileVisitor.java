package com.oop.bibtex.main.visitors;

import com.oop.bibtex.main.*;
import com.oop.bibtex.main.entries.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BasicFileVisitor implements IFileVisitor {

    private Character symbol;
    private ArrayList<String> types;
    private ArrayList<String> authors;

    public BasicFileVisitor(Character symbol, ArrayList<String> types, ArrayList<String> authors) {
        this.symbol = symbol;
        this.types = types;
        this.authors = authors;
    }

    void basicPrint(Entry entry, Attributes[] required, Attributes[] optional) {

        for (int i = 0; i < 40; i++)
            System.out.print(symbol);

        System.out.println("\n");

        System.out.println(entry.getClass().toString().split("\\.")[5].toUpperCase() + ": " + entry.key + "\n");

        List<Attributes> requiredAndOptional = new ArrayList<>(Arrays.asList(required));
        requiredAndOptional.addAll(Arrays.asList(optional));

        for (Attributes elem : requiredAndOptional) {
            String value = entry.records.get(elem);
            if (value != null) {
                if (elem == Attributes.AUTHOR) {

                    System.out.println(elem + ":");

                    for (String author : value.split("and ")) {
                        System.out.println("\t * " + author);
                    }

                } else {
                    System.out.println(elem + ": " + value);
                }
            }
        }

        System.out.println("\n");
    }

    @Override
    public void visit(BibTeXFile bibTeXFile) {

        System.out.println("End of file.\n");

    }

    @Override
    public void visit(StringEntity stringEntity) {

    }

    @Override
    public void visit(Comment comment) {

    }

    @Override
    public void visit(Preamble preamble) {

    }

    @Override
    public void visit(Article article) {

        if (types.isEmpty() || types.contains("ARTICLE"))
            if (authors.isEmpty() || authors.containsAll(Arrays.asList(article.records.get(Attributes.AUTHOR).split("and "))))
                basicPrint(article, Article.requiredFields, Article.optionalFields);

    }

    @Override
    public void visit(Book book) {

        if (types.isEmpty() || types.contains("BOOK"))
            if (authors.isEmpty() || (book.records.get(Attributes.AUTHOR) != null && authors.containsAll(Arrays.asList(book.records.get(Attributes.AUTHOR).split("and ")))))
                basicPrint(book, Book.requiredFields, Book.optionalFields);

    }

    @Override
    public void visit(Booklet booklet) {

        if (types.isEmpty() || types.contains("BOOKLET"))
            if (authors.isEmpty() || (booklet.records.get(Attributes.AUTHOR) != null && authors.containsAll(Arrays.asList(booklet.records.get(Attributes.AUTHOR).split("and ")))))
                basicPrint(booklet, Booklet.requiredFields, Booklet.optionalFields);

    }

    @Override
    public void visit(Conference conference) {

        if (types.isEmpty() || types.contains("CONFERENCE"))
            if (authors.isEmpty() || authors.containsAll(Arrays.asList(conference.records.get(Attributes.AUTHOR).split("and "))))
                basicPrint(conference, Conference.requiredFields, Conference.optionalFields);

    }

    @Override
    public void visit(InBook inBook) {

        if (types.isEmpty() || types.contains("INBOOK"))
            if (authors.isEmpty() || authors.containsAll(Arrays.asList(inBook.records.get(Attributes.AUTHOR).split("and "))))
                basicPrint(inBook, InBook.requiredFields, InBook.optionalFields);

    }

    @Override
    public void visit(InCollection inCollection) {

        if (types.isEmpty() || types.contains("INCOLLECTION"))
            if (authors.isEmpty() || authors.containsAll(Arrays.asList(inCollection.records.get(Attributes.AUTHOR).split("and "))))
                basicPrint(inCollection, InCollection.requiredFields, InCollection.optionalFields);

    }

    @Override
    public void visit(InProceedings inProceedings) {

        if (types.isEmpty() || types.contains("INPROCEEDINGS"))
            if (authors.isEmpty() || authors.containsAll(Arrays.asList(inProceedings.records.get(Attributes.AUTHOR).split("and "))))
                basicPrint(inProceedings, InProceedings.requiredFields, InProceedings.optionalFields);

    }

    @Override
    public void visit(Manual manual) {

        if (types.isEmpty() || types.contains("MANUAL"))
            if (authors.isEmpty() || (manual.records.get(Attributes.AUTHOR) != null && authors.containsAll(Arrays.asList(manual.records.get(Attributes.AUTHOR).split("and ")))))
                basicPrint(manual, Manual.requiredFields, Manual.optionalFields);

    }

    @Override
    public void visit(MasterThesis masterThesis) {

        if (types.isEmpty() || types.contains("MASTERTHESIS"))
            if (authors.isEmpty() || authors.containsAll(Arrays.asList(masterThesis.records.get(Attributes.AUTHOR).split("and "))))
                basicPrint(masterThesis, MasterThesis.requiredFields, MasterThesis.optionalFields);

    }

    @Override
    public void visit(Misc misc) {

        if (types.isEmpty() || types.contains("MISC"))
            if (authors.isEmpty() || (misc.records.get(Attributes.AUTHOR) != null && authors.containsAll(Arrays.asList(misc.records.get(Attributes.AUTHOR).split("and ")))))
                basicPrint(misc, Misc.requiredFields, Misc.optionalFields);

    }

    @Override
    public void visit(PhdThesis phdThesis) {

        if (types.isEmpty() || types.contains("PHDTHESIS"))
            if (authors.isEmpty() || authors.containsAll(Arrays.asList(phdThesis.records.get(Attributes.AUTHOR).split("and "))))
                basicPrint(phdThesis, PhdThesis.requiredFields, PhdThesis.optionalFields);

    }

    @Override
    public void visit(Proceedings proceedings) {

        if (types.isEmpty() || types.contains("PROCEEDINGS"))
            if (authors.isEmpty() || (proceedings.records.get(Attributes.AUTHOR) != null && authors.containsAll(Arrays.asList(proceedings.records.get(Attributes.AUTHOR).split("and ")))))
                basicPrint(proceedings, Proceedings.requiredFields, Proceedings.optionalFields);

    }

    @Override
    public void visit(TechReport techReport) {

        if (types.isEmpty() || types.contains("TECHREPORT"))
            if (authors.isEmpty() ||  authors.containsAll(Arrays.asList(techReport.records.get(Attributes.AUTHOR).split("and "))))
                basicPrint(techReport, TechReport.requiredFields, TechReport.optionalFields);

    }

    @Override
    public void visit(Unpublished unpublished) {

        if (types.isEmpty() || types.contains("UNPUBLISHED"))
            if (authors.isEmpty() || authors.containsAll(Arrays.asList(unpublished.records.get(Attributes.AUTHOR).split("and "))))
                basicPrint(unpublished, Unpublished.requiredFields, Unpublished.optionalFields);

    }
}