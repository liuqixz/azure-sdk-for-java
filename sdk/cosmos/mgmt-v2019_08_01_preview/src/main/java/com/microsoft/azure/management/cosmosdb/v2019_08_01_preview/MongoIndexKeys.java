/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.cosmosdb.v2019_08_01_preview;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Cosmos DB MongoDB collection resource object.
 */
public class MongoIndexKeys {
    /**
     * List of keys for each MongoDB collection in the Azure Cosmos DB service.
     */
    @JsonProperty(value = "keys")
    private List<String> keys;

    /**
     * Get list of keys for each MongoDB collection in the Azure Cosmos DB service.
     *
     * @return the keys value
     */
    public List<String> keys() {
        return this.keys;
    }

    /**
     * Set list of keys for each MongoDB collection in the Azure Cosmos DB service.
     *
     * @param keys the keys value to set
     * @return the MongoIndexKeys object itself.
     */
    public MongoIndexKeys withKeys(List<String> keys) {
        this.keys = keys;
        return this;
    }

}
