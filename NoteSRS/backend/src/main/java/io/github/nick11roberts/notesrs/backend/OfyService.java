package io.github.nick11roberts.notesrs.backend;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyFactory;
import com.googlecode.objectify.ObjectifyService;

/**
 * Created by nick on 12/28/15.
 */
public class OfyService {
    static {
        factory().register(OriginalWord.class);
        factory().register(ReplacementWord.class);
    }

    public static Objectify ofy() {
        return ObjectifyService.ofy();
    }

    public static ObjectifyFactory factory() {
        return ObjectifyService.factory();
    }
}