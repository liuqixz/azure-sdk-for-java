// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.management.containerregistry;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/** The OperationServiceSpecificationDefinition model. */
@Fluent
public final class OperationServiceSpecificationDefinition {
    /*
     * A list of Azure Monitoring metrics definition.
     */
    @JsonProperty(value = "metricSpecifications")
    private List<OperationMetricSpecificationDefinition> metricSpecifications;

    /**
     * Get the metricSpecifications property: A list of Azure Monitoring metrics definition.
     *
     * @return the metricSpecifications value.
     */
    public List<OperationMetricSpecificationDefinition> metricSpecifications() {
        return this.metricSpecifications;
    }

    /**
     * Set the metricSpecifications property: A list of Azure Monitoring metrics definition.
     *
     * @param metricSpecifications the metricSpecifications value to set.
     * @return the OperationServiceSpecificationDefinition object itself.
     */
    public OperationServiceSpecificationDefinition withMetricSpecifications(
        List<OperationMetricSpecificationDefinition> metricSpecifications) {
        this.metricSpecifications = metricSpecifications;
        return this;
    }
}
