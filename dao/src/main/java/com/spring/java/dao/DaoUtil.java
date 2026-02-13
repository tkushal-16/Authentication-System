/**
 * Copyright © 2016-2026 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.spring.java.dao;

import com.spring.java.common.data.id.UUIDBased;
import com.spring.java.dao.model.ToData;
import jakarta.persistence.metamodel.EntityType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public final class DaoUtil {

    private DaoUtil() {}

//    public static <T> PageData<T> toPageData(Page<? extends ToData<T>> page) {
//        List<T> data = convertDataList(page.getContent());
//        return new PageData<>(data, page.getTotalPages(), page.getTotalElements(), page.hasNext());
//    }

//    public static <T> PageData<T> pageToPageData(Slice<T> slice) {
//        int totalPages;
//        long totalElements;
//        if (slice instanceof Page<T> page) {
//            totalPages = page.getTotalPages();
//            totalElements = page.getTotalElements();
//        } else {
//            totalPages = 0;
//            totalElements = 0;
//        }
//        return new PageData<>(slice.getContent(), totalPages, totalElements, slice.hasNext());
//    }

//    public static Pageable toPageable(PageLink pageLink) {
//        return toPageable(pageLink, true);
//    }
//
//    public static Pageable toPageable(PageLink pageLink, boolean addDefaultSorting) {
//        return toPageable(pageLink, Collections.emptyMap(), addDefaultSorting);
//    }
//
//    public static Pageable toPageable(PageLink pageLink, Map<String, String> columnMap) {
//        return toPageable(pageLink, columnMap, true);
//    }
//
//    public static Pageable toPageable(PageLink pageLink, Map<String, String> columnMap, boolean addDefaultSorting) {
//        return PageRequest.of(pageLink.getPage(), pageLink.getPageSize(), pageLink.toSort(pageLink.getSortOrder(), columnMap, addDefaultSorting));
//    }
//
//    public static Pageable toPageable(PageLink pageLink, List<SortOrder> sortOrders) {
//        return toPageable(pageLink, Collections.emptyMap(), sortOrders);
//    }
//
//    public static Pageable toPageable(PageLink pageLink, String... sortColumns) {
//        return toPageable(pageLink, Collections.emptyMap(), Arrays.stream(sortColumns).map(column -> new SortOrder(column, SortOrder.Direction.ASC)).toList(), false);
//    }
//
//    public static Pageable toPageable(PageLink pageLink, Map<String, String> columnMap, List<SortOrder> sortOrders) {
//        return toPageable(pageLink, columnMap, sortOrders, true);
//    }
//
//    public static Pageable toPageable(PageLink pageLink, Map<String, String> columnMap, List<SortOrder> sortOrders, boolean addDefaultSorting) {
//        return PageRequest.of(pageLink.getPage(), pageLink.getPageSize(), pageLink.toSort(sortOrders, columnMap, addDefaultSorting));
//    }

    public static <T> List<T> convertDataList(Collection<? extends ToData<T>> toConvert) {
        if (CollectionUtils.isEmpty(toConvert)) {
            return Collections.emptyList();
        }
        List<T> converted = new ArrayList<>(toConvert.size());
        for (ToData<T> object : toConvert) {
            if (object != null) {
                converted.add(object.toData());
            }
        }
        return converted;
    }

    public static <T> T getData(ToData<T> data) {
        T object = null;
        if (data != null) {
            object = data.toData();
        }
        return object;
    }

    public static <T> T getData(Optional<? extends ToData<T>> data) {
        T object = null;
        if (data.isPresent()) {
            object = data.get().toData();
        }
        return object;
    }

    public static UUID getId(UUIDBased idBased) {
        UUID id = null;
        if (idBased != null) {
            id = idBased.getId();
        }
        return id;
    }

    public static List<UUID> toUUIDs(List<? extends UUIDBased> idBasedIds) {
        List<UUID> ids = new ArrayList<>();
        for (UUIDBased idBased : idBasedIds) {
            ids.add(getId(idBased));
        }
        return ids;
    }

    public static <I> List<I> fromUUIDs(List<UUID> uuids, Function<UUID, I> mapper) {
        return uuids.stream().map(mapper).collect(Collectors.toList());
    }

    public static <I> I toEntityId(UUID uuid, Function<UUID, I> creator) {
        if (uuid != null) {
            return creator.apply(uuid);
        } else {
            return null;
        }
    }

//    public static <T> void processInBatches(Function<PageLink, PageData<T>> finder, int batchSize, Consumer<T> processor) {
//        processBatches(finder, batchSize, batch -> batch.getData().forEach(processor));
//    }
//
//    public static <T> void processBatches(Function<PageLink, PageData<T>> finder, int batchSize, Consumer<PageData<T>> processor) {
//        PageLink pageLink = new PageLink(batchSize);
//        PageData<T> batch;
//
//        boolean hasNextBatch;
//        do {
//            batch = finder.apply(pageLink);
//            processor.accept(batch);
//
//            hasNextBatch = batch.hasNext();
//            pageLink = pageLink.nextPageLink();
//        } while (hasNextBatch);
//    }

    public static String getStringId(UUIDBased id) {
        if (id != null) {
            return id.toString();
        } else {
            return null;
        }
    }

}
