/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
/*
 * This code was generated by https://github.com/google/apis-client-generator/
 * (build: 2015-11-16 19:10:01 UTC)
 * on 2016-01-04 at 04:12:31 UTC 
 * Modify at your own risk.
 */

package io.github.nick11roberts.myApi;

/**
 * Service definition for MyApi (v1).
 *
 * <p>
 * This is an API
 * </p>
 *
 * <p>
 * For more information about this service, see the
 * <a href="" target="_blank">API Documentation</a>
 * </p>
 *
 * <p>
 * This service uses {@link MyApiRequestInitializer} to initialize global parameters via its
 * {@link Builder}.
 * </p>
 *
 * @since 1.3
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public class MyApi extends com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient {

  // Note: Leave this static initializer at the top of the file.
  static {
    com.google.api.client.util.Preconditions.checkState(
        com.google.api.client.googleapis.GoogleUtils.MAJOR_VERSION == 1 &&
        com.google.api.client.googleapis.GoogleUtils.MINOR_VERSION >= 15,
        "You are currently running with version %s of google-api-client. " +
        "You need at least version 1.15 of google-api-client to run version " +
        "1.21.0 of the myApi library.", com.google.api.client.googleapis.GoogleUtils.VERSION);
  }

  /**
   * The default encoded root URL of the service. This is determined when the library is generated
   * and normally should not be changed.
   *
   * @since 1.7
   */
  public static final String DEFAULT_ROOT_URL = "https://myApplicationId.appspot.com/_ah/api/";

  /**
   * The default encoded service path of the service. This is determined when the library is
   * generated and normally should not be changed.
   *
   * @since 1.7
   */
  public static final String DEFAULT_SERVICE_PATH = "myApi/v1/";

  /**
   * The default encoded base URL of the service. This is determined when the library is generated
   * and normally should not be changed.
   */
  public static final String DEFAULT_BASE_URL = DEFAULT_ROOT_URL + DEFAULT_SERVICE_PATH;

  /**
   * Constructor.
   *
   * <p>
   * Use {@link Builder} if you need to specify any of the optional parameters.
   * </p>
   *
   * @param transport HTTP transport, which should normally be:
   *        <ul>
   *        <li>Google App Engine:
   *        {@code com.google.api.client.extensions.appengine.http.UrlFetchTransport}</li>
   *        <li>Android: {@code newCompatibleTransport} from
   *        {@code com.google.api.client.extensions.android.http.AndroidHttp}</li>
   *        <li>Java: {@link com.google.api.client.googleapis.javanet.GoogleNetHttpTransport#newTrustedTransport()}
   *        </li>
   *        </ul>
   * @param jsonFactory JSON factory, which may be:
   *        <ul>
   *        <li>Jackson: {@code com.google.api.client.json.jackson2.JacksonFactory}</li>
   *        <li>Google GSON: {@code com.google.api.client.json.gson.GsonFactory}</li>
   *        <li>Android Honeycomb or higher:
   *        {@code com.google.api.client.extensions.android.json.AndroidJsonFactory}</li>
   *        </ul>
   * @param httpRequestInitializer HTTP request initializer or {@code null} for none
   * @since 1.7
   */
  public MyApi(com.google.api.client.http.HttpTransport transport, com.google.api.client.json.JsonFactory jsonFactory,
      com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
    this(new Builder(transport, jsonFactory, httpRequestInitializer));
  }

  /**
   * @param builder builder
   */
  MyApi(Builder builder) {
    super(builder);
  }

  @Override
  protected void initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest<?> httpClientRequest) throws java.io.IOException {
    super.initialize(httpClientRequest);
  }

  /**
   * Create a request for the method "correctText".
   *
   * This request holds the parameters needed by the myApi server.  After setting any optional
   * parameters, call the {@link CorrectText#execute()} method to invoke the remote operation.
   *
   * @param input
   * @return the request
   */
  public CorrectText correctText(java.lang.String input) throws java.io.IOException {
    CorrectText result = new CorrectText(input);
    initialize(result);
    return result;
  }

  public class CorrectText extends MyApiRequest<io.github.nick11roberts.myApi.model.StringWrapper> {

    private static final String REST_PATH = "correctText/{input}";

    /**
     * Create a request for the method "correctText".
     *
     * This request holds the parameters needed by the the myApi server.  After setting any optional
     * parameters, call the {@link CorrectText#execute()} method to invoke the remote operation. <p>
     * {@link
     * CorrectText#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)}
     * must be called to initialize this instance immediately after invoking the constructor. </p>
     *
     * @param input
     * @since 1.13
     */
    protected CorrectText(java.lang.String input) {
      super(MyApi.this, "POST", REST_PATH, null, io.github.nick11roberts.myApi.model.StringWrapper.class);
      this.input = com.google.api.client.util.Preconditions.checkNotNull(input, "Required parameter input must be specified.");
    }

    @Override
    public CorrectText setAlt(java.lang.String alt) {
      return (CorrectText) super.setAlt(alt);
    }

    @Override
    public CorrectText setFields(java.lang.String fields) {
      return (CorrectText) super.setFields(fields);
    }

    @Override
    public CorrectText setKey(java.lang.String key) {
      return (CorrectText) super.setKey(key);
    }

    @Override
    public CorrectText setOauthToken(java.lang.String oauthToken) {
      return (CorrectText) super.setOauthToken(oauthToken);
    }

    @Override
    public CorrectText setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (CorrectText) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public CorrectText setQuotaUser(java.lang.String quotaUser) {
      return (CorrectText) super.setQuotaUser(quotaUser);
    }

    @Override
    public CorrectText setUserIp(java.lang.String userIp) {
      return (CorrectText) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.String input;

    /**

     */
    public java.lang.String getInput() {
      return input;
    }

    public CorrectText setInput(java.lang.String input) {
      this.input = input;
      return this;
    }

    @Override
    public CorrectText set(String parameterName, Object value) {
      return (CorrectText) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "insertAutoCucumberListItem".
   *
   * This request holds the parameters needed by the myApi server.  After setting any optional
   * parameters, call the {@link InsertAutoCucumberListItem#execute()} method to invoke the remote
   * operation.
   *
   * @param word
   * @param correction
   * @return the request
   */
  public InsertAutoCucumberListItem insertAutoCucumberListItem(java.lang.String word, java.lang.String correction) throws java.io.IOException {
    InsertAutoCucumberListItem result = new InsertAutoCucumberListItem(word, correction);
    initialize(result);
    return result;
  }

  public class InsertAutoCucumberListItem extends MyApiRequest<io.github.nick11roberts.myApi.model.StringWrapper> {

    private static final String REST_PATH = "stringwrapper/{word}/{correction}";

    /**
     * Create a request for the method "insertAutoCucumberListItem".
     *
     * This request holds the parameters needed by the the myApi server.  After setting any optional
     * parameters, call the {@link InsertAutoCucumberListItem#execute()} method to invoke the remote
     * operation. <p> {@link InsertAutoCucumberListItem#initialize(com.google.api.client.googleapis.se
     * rvices.AbstractGoogleClientRequest)} must be called to initialize this instance immediately
     * after invoking the constructor. </p>
     *
     * @param word
     * @param correction
     * @since 1.13
     */
    protected InsertAutoCucumberListItem(java.lang.String word, java.lang.String correction) {
      super(MyApi.this, "POST", REST_PATH, null, io.github.nick11roberts.myApi.model.StringWrapper.class);
      this.word = com.google.api.client.util.Preconditions.checkNotNull(word, "Required parameter word must be specified.");
      this.correction = com.google.api.client.util.Preconditions.checkNotNull(correction, "Required parameter correction must be specified.");
    }

    @Override
    public InsertAutoCucumberListItem setAlt(java.lang.String alt) {
      return (InsertAutoCucumberListItem) super.setAlt(alt);
    }

    @Override
    public InsertAutoCucumberListItem setFields(java.lang.String fields) {
      return (InsertAutoCucumberListItem) super.setFields(fields);
    }

    @Override
    public InsertAutoCucumberListItem setKey(java.lang.String key) {
      return (InsertAutoCucumberListItem) super.setKey(key);
    }

    @Override
    public InsertAutoCucumberListItem setOauthToken(java.lang.String oauthToken) {
      return (InsertAutoCucumberListItem) super.setOauthToken(oauthToken);
    }

    @Override
    public InsertAutoCucumberListItem setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (InsertAutoCucumberListItem) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public InsertAutoCucumberListItem setQuotaUser(java.lang.String quotaUser) {
      return (InsertAutoCucumberListItem) super.setQuotaUser(quotaUser);
    }

    @Override
    public InsertAutoCucumberListItem setUserIp(java.lang.String userIp) {
      return (InsertAutoCucumberListItem) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.String word;

    /**

     */
    public java.lang.String getWord() {
      return word;
    }

    public InsertAutoCucumberListItem setWord(java.lang.String word) {
      this.word = word;
      return this;
    }

    @com.google.api.client.util.Key
    private java.lang.String correction;

    /**

     */
    public java.lang.String getCorrection() {
      return correction;
    }

    public InsertAutoCucumberListItem setCorrection(java.lang.String correction) {
      this.correction = correction;
      return this;
    }

    @Override
    public InsertAutoCucumberListItem set(String parameterName, Object value) {
      return (InsertAutoCucumberListItem) super.set(parameterName, value);
    }
  }

  /**
   * Builder for {@link MyApi}.
   *
   * <p>
   * Implementation is not thread-safe.
   * </p>
   *
   * @since 1.3.0
   */
  public static final class Builder extends com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient.Builder {

    /**
     * Returns an instance of a new builder.
     *
     * @param transport HTTP transport, which should normally be:
     *        <ul>
     *        <li>Google App Engine:
     *        {@code com.google.api.client.extensions.appengine.http.UrlFetchTransport}</li>
     *        <li>Android: {@code newCompatibleTransport} from
     *        {@code com.google.api.client.extensions.android.http.AndroidHttp}</li>
     *        <li>Java: {@link com.google.api.client.googleapis.javanet.GoogleNetHttpTransport#newTrustedTransport()}
     *        </li>
     *        </ul>
     * @param jsonFactory JSON factory, which may be:
     *        <ul>
     *        <li>Jackson: {@code com.google.api.client.json.jackson2.JacksonFactory}</li>
     *        <li>Google GSON: {@code com.google.api.client.json.gson.GsonFactory}</li>
     *        <li>Android Honeycomb or higher:
     *        {@code com.google.api.client.extensions.android.json.AndroidJsonFactory}</li>
     *        </ul>
     * @param httpRequestInitializer HTTP request initializer or {@code null} for none
     * @since 1.7
     */
    public Builder(com.google.api.client.http.HttpTransport transport, com.google.api.client.json.JsonFactory jsonFactory,
        com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
      super(
          transport,
          jsonFactory,
          DEFAULT_ROOT_URL,
          DEFAULT_SERVICE_PATH,
          httpRequestInitializer,
          false);
    }

    /** Builds a new instance of {@link MyApi}. */
    @Override
    public MyApi build() {
      return new MyApi(this);
    }

    @Override
    public Builder setRootUrl(String rootUrl) {
      return (Builder) super.setRootUrl(rootUrl);
    }

    @Override
    public Builder setServicePath(String servicePath) {
      return (Builder) super.setServicePath(servicePath);
    }

    @Override
    public Builder setHttpRequestInitializer(com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
      return (Builder) super.setHttpRequestInitializer(httpRequestInitializer);
    }

    @Override
    public Builder setApplicationName(String applicationName) {
      return (Builder) super.setApplicationName(applicationName);
    }

    @Override
    public Builder setSuppressPatternChecks(boolean suppressPatternChecks) {
      return (Builder) super.setSuppressPatternChecks(suppressPatternChecks);
    }

    @Override
    public Builder setSuppressRequiredParameterChecks(boolean suppressRequiredParameterChecks) {
      return (Builder) super.setSuppressRequiredParameterChecks(suppressRequiredParameterChecks);
    }

    @Override
    public Builder setSuppressAllChecks(boolean suppressAllChecks) {
      return (Builder) super.setSuppressAllChecks(suppressAllChecks);
    }

    /**
     * Set the {@link MyApiRequestInitializer}.
     *
     * @since 1.12
     */
    public Builder setMyApiRequestInitializer(
        MyApiRequestInitializer myapiRequestInitializer) {
      return (Builder) super.setGoogleClientRequestInitializer(myapiRequestInitializer);
    }

    @Override
    public Builder setGoogleClientRequestInitializer(
        com.google.api.client.googleapis.services.GoogleClientRequestInitializer googleClientRequestInitializer) {
      return (Builder) super.setGoogleClientRequestInitializer(googleClientRequestInitializer);
    }
  }
}
