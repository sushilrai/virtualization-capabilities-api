/**
 * Copyright &copy; 2017 Dell Inc. or its subsidiaries.  All Rights Reserved.
 */

package com.dell.cpsd.endpoint.registration;

/**
 * Copyright &copy; 2017 Dell Inc. or its subsidiaries.  All Rights Reserved.
 */
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.File;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.dell.cpsd.endpoint.registration.JSONSchemaUtil.validateSchema;

/**
 * This is the schema validation test, this validates json messages
 * conforms to the API.
 * <p>
 * Copyright &copy; 2017 Dell Inc. or its subsidiaries.  All Rights Reserved.
 * </p>
 *
 * @version 1.0
 * @since 1.0
 */
@Ignore
@RunWith(Parameterized.class)
public class ValidateExamplesTest
{
    public static final String SCHEMA_DIR   = "/virtualization-capabilities-api/schema/json/";
    public static final String EXAMPLE_DIR  = "/virtualization-capabilities-api/schema/example/";
    public static final String INCLUDES_DIR = SCHEMA_DIR;

    @Parameterized.Parameters(name = "{index}: {0} model test")
    public static List<String> getExamples() throws URISyntaxException {
        File resources = new File(ValidateExamplesTest.class.getResource(EXAMPLE_DIR).toURI());
        return Arrays.stream(resources.list()).filter(file -> file.endsWith(".json")).collect(Collectors.toList());
    }
    @Parameterized.Parameter
    public String name;

    @Test
    public void exampleModelTest() throws Exception
    {
        validateSchema(SCHEMA_DIR + name.replace(".json", ".jsd"), EXAMPLE_DIR + name);
    }
}
