package type.dictionary.implementation;

import io.clientcore.core.annotations.ServiceInterface;
import io.clientcore.core.http.RestProxy;
import io.clientcore.core.http.annotations.BodyParam;
import io.clientcore.core.http.annotations.HeaderParam;
import io.clientcore.core.http.annotations.HostParam;
import io.clientcore.core.http.annotations.HttpRequestInformation;
import io.clientcore.core.http.annotations.UnexpectedResponseExceptionDetail;
import io.clientcore.core.http.exceptions.HttpResponseException;
import io.clientcore.core.http.models.HttpMethod;
import io.clientcore.core.http.models.RequestOptions;
import io.clientcore.core.http.models.Response;
import io.clientcore.core.models.binarydata.BinaryData;
import java.util.Map;
import type.dictionary.InnerModel;

/**
 * An instance of this class provides access to all the operations defined in ModelValues.
 */
public final class ModelValuesImpl {
    /**
     * The proxy service used to perform REST calls.
     */
    private final ModelValuesService service;

    /**
     * The service client containing this operation class.
     */
    private final DictionaryClientImpl client;

    /**
     * Initializes an instance of ModelValuesImpl.
     * 
     * @param client the instance of the service client containing this operation class.
     */
    ModelValuesImpl(DictionaryClientImpl client) {
        this.service = RestProxy.create(ModelValuesService.class, client.getHttpPipeline());
        this.client = client;
    }

    /**
     * The interface defining all the services for DictionaryClientModelValues to be used by the proxy service to
     * perform REST calls.
     */
    @ServiceInterface(name = "DictionaryClientMode", host = "{endpoint}")
    public interface ModelValuesService {
        @HttpRequestInformation(method = HttpMethod.GET, path = "/type/dictionary/model", expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<Map<String, InnerModel>> getSync(@HostParam("endpoint") String endpoint,
            @HeaderParam("Accept") String accept, RequestOptions requestOptions);

        @HttpRequestInformation(method = HttpMethod.PUT, path = "/type/dictionary/model", expectedStatusCodes = { 204 })
        @UnexpectedResponseExceptionDetail
        Response<Void> putSync(@HostParam("endpoint") String endpoint, @HeaderParam("Content-Type") String contentType,
            @BodyParam("application/json") BinaryData body, RequestOptions requestOptions);
    }

    /**
     * The get operation.
     * <p><strong>Response Body Schema</strong></p>
     * 
     * <pre>
     * {@code
     * {
     *     String (Required): {
     *         property: String (Required)
     *         children (Optional): {
     *             String (Required): (recursive schema, see String above)
     *         }
     *     }
     * }
     * }
     * </pre>
     * 
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @throws HttpResponseException thrown if the service returns an error.
     * @return the response.
     */
    public Response<Map<String, InnerModel>> getWithResponse(RequestOptions requestOptions) {
        final String accept = "application/json";
        return service.getSync(this.client.getEndpoint(), accept, requestOptions);
    }

    /**
     * The put operation.
     * <p><strong>Request Body Schema</strong></p>
     * 
     * <pre>
     * {@code
     * {
     *     String (Required): {
     *         property: String (Required)
     *         children (Optional): {
     *             String (Required): (recursive schema, see String above)
     *         }
     *     }
     * }
     * }
     * </pre>
     * 
     * @param body The body parameter.
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @throws HttpResponseException thrown if the service returns an error.
     * @return the response.
     */
    public Response<Void> putWithResponse(BinaryData body, RequestOptions requestOptions) {
        final String contentType = "application/json";
        return service.putSync(this.client.getEndpoint(), contentType, body, requestOptions);
    }
}
