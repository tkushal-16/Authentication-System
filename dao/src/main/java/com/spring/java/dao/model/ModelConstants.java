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
package com.spring.java.dao.model;

import java.util.UUID;

public class ModelConstants {

    private ModelConstants() {}


    // this is the difference between midnight October 15, 1582 UTC and midnight January 1, 1970 UTC as 100 nanosecond units
    public static final long EPOCH_DIFF = 122192928000000000L;

    /**
     * Generic constants.
     */
    public static final String ID_PROPERTY = "id";
    public static final String CREATED_TIME_PROPERTY = "created_time";
    public static final String USER_ID_PROPERTY = "user_id";
    public static final String TENANT_ID_PROPERTY = "tenant_id";
    public static final String CUSTOMER_ID_PROPERTY = "customer_id";
    public static final String ASSIGNEE_ID_PROPERTY = "assignee_id";
    public static final String DEVICE_ID_PROPERTY = "device_id";
    public static final String TITLE_PROPERTY = "title";
    public static final String NAME_PROPERTY = "name";
    public static final String ALIAS_PROPERTY = "alias";
    public static final String SEARCH_TEXT_PROPERTY = "search_text";
    public static final String ADDITIONAL_INFO_PROPERTY = "additional_info";
    public static final String ENTITY_TYPE_PROPERTY = "entity_type";
    public static final String VERSION_PROPERTY = "version";

    public static final String ENTITY_TYPE_COLUMN = ENTITY_TYPE_PROPERTY;
    public static final String TENANT_ID_COLUMN = "tenant_id";
    public static final String ENTITY_ID_COLUMN = "entity_id";
    public static final String ATTRIBUTE_TYPE_COLUMN = "attribute_type";
    public static final String ATTRIBUTE_KEY_COLUMN = "attribute_key";
    public static final String LAST_UPDATE_TS_COLUMN = "last_update_ts";
    public static final String VERSION_COLUMN = "version";

    /**
     * User constants.
     */
    public static final String USER_PG_HIBERNATE_TABLE_NAME = "tb_user";
    public static final String USER_TENANT_ID_PROPERTY = TENANT_ID_PROPERTY;
    public static final String USER_CUSTOMER_ID_PROPERTY = CUSTOMER_ID_PROPERTY;
    public static final String USER_EMAIL_PROPERTY = "email";
    public static final String USER_AUTHORITY_PROPERTY = "authority";
    public static final String USER_FIRST_NAME_PROPERTY = "first_name";
    public static final String USER_LAST_NAME_PROPERTY = "last_name";
    public static final String USER_ADDITIONAL_INFO_PROPERTY = ADDITIONAL_INFO_PROPERTY;

    /**
     * User_credentials constants.
     */
    public static final String USER_CREDENTIALS_TABLE_NAME = "user_credentials";
    public static final String USER_CREDENTIALS_USER_ID_PROPERTY = USER_ID_PROPERTY;
    public static final String USER_CREDENTIALS_ENABLED_PROPERTY = "enabled";
    public static final String USER_CREDENTIALS_PASSWORD_PROPERTY = "password"; //NOSONAR, the constant used to identify password column name (not password value itself)
    public static final String USER_CREDENTIALS_ACTIVATE_TOKEN_PROPERTY = "activate_token";
    public static final String USER_CREDENTIALS_ACTIVATE_TOKEN_EXP_TIME_PROPERTY = "activate_token_exp_time";
    public static final String USER_CREDENTIALS_RESET_TOKEN_PROPERTY = "reset_token";
    public static final String USER_CREDENTIALS_RESET_TOKEN_EXP_TIME_PROPERTY = "reset_token_exp_time";
    public static final String USER_CREDENTIALS_LAST_LOGIN_TS_PROPERTY = "last_login_ts";
    public static final String USER_CREDENTIALS_FAILED_LOGIN_ATTEMPTS_PROPERTY = "failed_login_attempts";

    /**
     * User settings constants.
     */
    public static final String USER_SETTINGS_TABLE_NAME = "user_settings";
    public static final String USER_SETTINGS_USER_ID_PROPERTY = USER_ID_PROPERTY;
    public static final String USER_SETTINGS_TYPE_PROPERTY = "type";
    public static final String USER_SETTINGS_SETTINGS = "settings";

    /**
     * Admin_settings constants.
     */
    public static final String ADMIN_SETTINGS_TABLE_NAME = "admin_settings";

    public static final String ADMIN_SETTINGS_TENANT_ID_PROPERTY = TENANT_ID_PROPERTY;
    public static final String ADMIN_SETTINGS_KEY_PROPERTY = "key";
    public static final String ADMIN_SETTINGS_JSON_VALUE_PROPERTY = "json_value";












}
