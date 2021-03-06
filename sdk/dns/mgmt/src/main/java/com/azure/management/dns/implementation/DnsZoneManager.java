// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.management.dns.implementation;

import com.azure.core.credential.TokenCredential;
import com.azure.core.http.HttpPipeline;
import com.azure.management.dns.DnsZones;
import com.azure.management.dns.models.DnsManagementClientBuilder;
import com.azure.management.dns.models.DnsManagementClientImpl;
import com.azure.management.resources.fluentcore.arm.AzureConfigurable;
import com.azure.management.resources.fluentcore.arm.implementation.AzureConfigurableImpl;
import com.azure.management.resources.fluentcore.arm.implementation.Manager;
import com.azure.management.resources.fluentcore.profile.AzureProfile;
import com.azure.management.resources.fluentcore.utils.HttpPipelineProvider;
import com.azure.management.resources.fluentcore.utils.SdkContext;

/** Entry point to Azure DNS zone management. */
public final class DnsZoneManager extends Manager<DnsZoneManager, DnsManagementClientImpl> {
    // Collections
    private DnsZones zones;

    /**
     * Get a Configurable instance that can be used to create {@link DnsZoneManager} with optional configuration.
     *
     * @return the instance allowing configurations
     */
    public static Configurable configure() {
        return new DnsZoneManager.ConfigurableImpl();
    }

    /**
     * Creates an instance of DnsZoneManager that exposes DNS zone management API entry points.
     *
     * @param credential the credential to use
     * @param profile the profile to use
     * @return the DnsZoneManager
     */
    public static DnsZoneManager authenticate(TokenCredential credential, AzureProfile profile) {
        return authenticate(HttpPipelineProvider.buildHttpPipeline(credential, profile), profile);
    }

    /**
     * Creates an instance of DnsZoneManager that exposes DNS zone management API entry points.
     *
     * @param httpPipeline the HttpPipeline to be used for API calls.
     * @param profile the profile to use
     * @return the DnsZoneManager
     */
    public static DnsZoneManager authenticate(HttpPipeline httpPipeline, AzureProfile profile) {
        return new DnsZoneManager(httpPipeline, profile, new SdkContext());
    }

    /**
     * Creates an instance of DnsZoneManager that exposes DNS zone management API entry points.
     *
     * @param httpPipeline the HttpPipeline to be used for API calls.
     * @param profile the profile to use
     * @param sdkContext the sdk context
     * @return the DnsZoneManager
     */
    public static DnsZoneManager authenticate(HttpPipeline httpPipeline, AzureProfile profile, SdkContext sdkContext) {
        return new DnsZoneManager(httpPipeline, profile, sdkContext);
    }

    /** The interface allowing configurations to be set. */
    public interface Configurable extends AzureConfigurable<Configurable> {
        /**
         * Creates an instance of DnsZoneManager that exposes DNS zone API entry points.
         *
         * @param credential the credential to use
         * @param profile the profile to use
         * @return the interface exposing DNS zone management API entry points that work across subscriptions
         */
        DnsZoneManager authenticate(TokenCredential credential, AzureProfile profile);
    }

    /** The implementation for Configurable interface. */
    private static class ConfigurableImpl extends AzureConfigurableImpl<Configurable> implements Configurable {

        public DnsZoneManager authenticate(TokenCredential credential, AzureProfile profile) {
            return DnsZoneManager.authenticate(buildHttpPipeline(credential, profile), profile);
        }
    }

    private DnsZoneManager(HttpPipeline httpPipeline, AzureProfile profile, SdkContext sdkContext) {
        super(
            httpPipeline,
            profile,
            new DnsManagementClientBuilder()
                .pipeline(httpPipeline)
                .subscriptionId(profile.subscriptionId())
                .buildClient(),
            sdkContext);
    }

    /** @return entry point to DNS zone manager zone management */
    public DnsZones zones() {
        if (this.zones == null) {
            this.zones = new DnsZonesImpl(this);
        }
        return this.zones;
    }
}
