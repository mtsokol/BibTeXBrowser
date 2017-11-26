package com.oop.bibtex.main.entries;

import com.oop.bibtex.main.Attributes;
import com.oop.bibtex.main.Entry;
import com.oop.bibtex.main.IFileVisitor;
import static com.oop.bibtex.main.Attributes.*;

import java.util.Map;

public class PhdThesis extends Entry {

    public static final Attributes[] requiredFields = {AUTHOR, TITLE, SCHOOL, YEAR};
    public static final Attributes[] optionalFields = {TYPE, ADDRESS, MONTH, NOTE, KEY};

    public PhdThesis(Map<Attributes, String> records) {
        super(records);
    }

    @Override
    public void accept(IFileVisitor visitor) {
        visitor.visit(this);
    }
}
