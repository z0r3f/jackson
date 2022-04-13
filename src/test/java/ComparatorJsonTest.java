import org.json.JSONException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Objects;

import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;

class ComparatorJsonTest {
    static String one, two;

    @BeforeAll
    static void setup() throws IOException {
        // Put files in src/test/resources dir
        one = getString("dev_20220412.json");
        two = getString("loc_20220412.json");
    }

    @Test
    void compareJsonFiles() throws JSONException {
        assertEquals(one, two, false);
        // Requires reversing the order because the extra attributes in
        // the second JSON parameter do not result in failure
        assertEquals(two, one, false);
    }

    static String getString(String path) throws IOException {
        return new String(
                Objects.requireNonNull(
                        ComparatorJsonTest.class.getClassLoader().getResourceAsStream(path)
                ).readAllBytes()
        );
    }
}
