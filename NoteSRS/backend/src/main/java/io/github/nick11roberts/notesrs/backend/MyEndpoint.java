/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package io.github.nick11roberts.notesrs.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;

import javax.inject.Named;

import static io.github.nick11roberts.notesrs.backend.OfyService.ofy;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "nick11roberts.github.io",
                ownerName = "nick11roberts.github.io",
                packagePath = ""
        )
)
public class MyEndpoint {

    /**
     * A simple endpoint method that takes a name and says Hi back
     */
    @ApiMethod(name = "correctText")
    public StringWrapper correctText(@Named("input") String input) {
        StringWrapper response = new StringWrapper();
        FindAndReplace findAndReplaceHelper = new FindAndReplace();

        response.setData(
                findAndReplaceHelper.correctTextMatrix(
                        findAndReplaceHelper.parseToTextMatrix(input)
                )

        );

        return response;
    }

    /**
     * A simple endpoint method that takes a name and says Hi back, just kidding...
     */
    @ApiMethod(name = "insertAutoCucumberListItem")
    public StringWrapper insertAutoCucumberListItem(@Named("word") String word, @Named("correction") String correction) {
        StringWrapper success = new StringWrapper();
        // Get the Datastore Service
        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        String editedWord = word.toLowerCase().replaceAll("[^a-z ]", "").replaceAll(" ", "");
        String editedCorrection = correction.toLowerCase().replaceAll("[^a-z ]", "").replaceAll(" ", "");
        OriginalWord newWord = new OriginalWord(editedWord);
        ReplacementWord newReplacement = new ReplacementWord(editedCorrection);
        Query.Filter exactWordFilter = new Query.FilterPredicate("word", Query.FilterOperator.EQUAL, word);
        Query q = new Query("OriginalWord").setFilter(exactWordFilter);
        PreparedQuery pq = datastore.prepare(q);
        Entity result = pq.asSingleEntity();
        if(result == null){
            ofy().save().entity(newWord).now();
        }

        newReplacement.setOriginalWordRef(newWord);
        ofy().save().entity(newReplacement).now();

        success.setData(editedWord + " -> " + editedCorrection);
        return success;
    }

}
