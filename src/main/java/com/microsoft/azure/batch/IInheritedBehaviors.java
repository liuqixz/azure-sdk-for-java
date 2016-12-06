/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.microsoft.azure.batch;

import java.util.Collection;

/**
 * Methods and properties that are inherited from the instantiating parent object.
 * The custom behaviors collection is initially populated by instantiation or by copying from the instantiating parent object (inheritance).
 * In this model, the collections are independent but the members are shared references.
 * Members of this collection alter or customize various behaviors of Azure Batch Service client objects.
 * These behaviors are generally inherited by any child class instances.
 * Modifications are applied in the order of the collection.
 * The last write wins.
 */
public interface IInheritedBehaviors {

    /**
     * Gets a collection of behaviors that modify or customize requests to the Batch service.
     *
     * @return A collection of {@link BatchClientBehavior} instances
     */
    Collection<BatchClientBehavior> customBehaviors();

    /**
     * Sets a collection of behaviors that modify or customize requests to the Batch service.
     *
     * @param behaviors The collection of {@link BatchClientBehavior} instances
     * @return The current instance
     */
    IInheritedBehaviors withCustomBehaviors(Collection<BatchClientBehavior> behaviors);

}
