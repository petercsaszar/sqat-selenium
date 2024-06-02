import com.mailslurp.apis.InboxControllerApi;
import com.mailslurp.apis.WaitForControllerApi;
import com.mailslurp.clients.ApiClient;
import com.mailslurp.clients.ApiException;
import com.mailslurp.clients.Configuration;
import com.mailslurp.models.Email;
import com.mailslurp.models.Inbox;

import java.util.UUID;

public class MailChecker {

    // set a timeout as fetching emails might take time
    private static final Long TIMEOUT_MILLIS = 30000L;
    private static final String WEBDRIVER_PATH = "/path/to/your/webdriver";

    private ApiClient mailslurpClient;

    public MailChecker(String apikey) {
        // setup mailslurp
        mailslurpClient = Configuration.getDefaultApiClient();
        mailslurpClient.setApiKey(apikey);
        mailslurpClient.setConnectTimeout(TIMEOUT_MILLIS.intValue());
    }

    public String getNewestEmail(UUID inboxId) throws ApiException {
        InboxControllerApi inboxControllerApi = new InboxControllerApi(mailslurpClient);
        Inbox inbox = inboxControllerApi.getInbox(inboxId);

        WaitForControllerApi waitForControllerApi = new WaitForControllerApi(mailslurpClient);
        Email email = waitForControllerApi.waitForLatestEmail(inbox.getId(), TIMEOUT_MILLIS, true);

        return email.getSubject();
    }
}