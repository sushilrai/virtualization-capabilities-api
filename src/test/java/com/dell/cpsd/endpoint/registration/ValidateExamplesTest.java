/**
 * Copyright &copy; 2017 Dell Inc. or its subsidiaries.  All Rights Reserved.
 * Dell EMC Confidential/Proprietary Information
 */

package com.dell.cpsd.endpoint.registration;

import org.junit.Test;

import static com.dell.cpsd.common.json.utils.JsonSchemaValidation.validateSchema;
import static org.junit.Assert.assertNull;

/**
 * This is the schema validation test, this validates json messages
 * conforms to the API.
 * <p>
 * Copyright &copy; 2017 Dell Inc. or its subsidiaries.  All Rights Reserved.
 * Dell EMC Confidential/Proprietary Information
 * </p>
 *
 * @version 1.0
 * @since 1.0
 */
public class ValidateExamplesTest
{
    public static final String SCHEMA_DIR   = "/virtualization-capabilities-api/schema/json/";
    public static final String EXAMPLE_DIR  = "/virtualization-capabilities-api/schema/example/";
    public static final String INCLUDES_DIR = SCHEMA_DIR + "includes";

    @Test
    public void virtualSwitchInfoTest() throws Exception
    {
        String jsdName = "VirtualSwitchInfoMessage";
        String jsonName = "VirtualSwitchInfo";
        String errors = validateSchema(SCHEMA_DIR + jsdName + ".jsd", EXAMPLE_DIR + jsonName + ".json", INCLUDES_DIR);
        assertNull(errors, errors);
    }

    @Test
    public void virtualNicInfoTest() throws Exception
    {
        String jsdName = "VirtualNicInfoMessage";
        String jsonName = "VirtualNicInfo";
        String errors = validateSchema(SCHEMA_DIR + jsdName + ".jsd", EXAMPLE_DIR + jsonName + ".json", INCLUDES_DIR);
        assertNull(errors, errors);
    }

    @Test
    public void virtualMachineInfoTest() throws Exception
    {
        String jsdName = "VirtualMachineInfoMessage";
        String jsonName = "VirtualMachineInfo";
        String errors = validateSchema(SCHEMA_DIR + jsdName + ".jsd", EXAMPLE_DIR + jsonName + ".json", INCLUDES_DIR);
        assertNull(errors, errors);
    }

    @Test
    public void vcenterDiscoveryRequestInfoTest() throws Exception
    {
        String jsdName = "DiscoveryRequestInfoMessage";
        String jsonName = "VCenterDiscoverRequestMessage";
        String errors = validateSchema(SCHEMA_DIR + jsdName + ".jsd", EXAMPLE_DIR + jsonName + ".json", INCLUDES_DIR);
        assertNull(errors, errors);
    }

    @Test
    public void hostFruDataTest() throws Exception
    {
        String jsdName = "HostFruDataMessage";
        String jsonName = "HostFruData";
        String errors = validateSchema(SCHEMA_DIR + jsdName + ".jsd", EXAMPLE_DIR + jsonName + ".json", INCLUDES_DIR);
        assertNull(errors, errors);
    }

    @Test
    public void networkConfigTest() throws Exception
    {
        String jsdName = "NetworkConfigMessage";
        String jsonName = "HostNetworkingConfig";
        String errors = validateSchema(SCHEMA_DIR + jsdName + ".jsd", EXAMPLE_DIR + jsonName + ".json", INCLUDES_DIR);
        assertNull(errors, errors);
    }

    @Test
    public void physicalNicInfoTest() throws Exception
    {
        String jsdName = "PhysicalNicInfoMessage";
        String jsonName = "PhysicalNicInfo";
        String errors = validateSchema(SCHEMA_DIR + jsdName + ".jsd", EXAMPLE_DIR + jsonName + ".json", INCLUDES_DIR);
        assertNull(errors, errors);
    }

    @Test
    public void portGroupInfoTest() throws Exception
    {
        String jsdName = "PortGroupInfoMessage";
        String jsonName = "PortgroupInfo";
        String errors = validateSchema(SCHEMA_DIR + jsdName + ".jsd", EXAMPLE_DIR + jsonName + ".json", INCLUDES_DIR);
        assertNull(errors, errors);
    }

    @Test
    public void consulRegistrationInfoTest() throws Exception
    {
        String jsdName = "ConsulRegisterRequestMessage";
        String jsonName = "ConsulRegisterRequestMessage";
        String errors = validateSchema(SCHEMA_DIR + jsdName + ".jsd", EXAMPLE_DIR + jsonName + ".json", INCLUDES_DIR);
        assertNull(errors, errors);
    }
}

