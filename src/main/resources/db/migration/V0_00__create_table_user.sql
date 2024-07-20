DO
$$
    BEGIN
        CREATE TABLE public."aoa_user"
        (
            id             UUID PRIMARY KEY         NOT NULL,
            name           TEXT                     NOT NULL,
            dob            DATE                     NOT NULL,
            phone_number   VARCHAR(10)              NOT NULL,
            personality_id VARCHAR(12)              NOT NULL,
            gender         VARCHAR(6)               NOT NULL,
            created        TIMESTAMP WITH TIME ZONE NOT NULL,
            modified       TIMESTAMP WITH TIME ZONE NOT NULL,
            created_by     TEXT                     NOT NULL,
            modified_by    TEXT                     NOT NULL,
            is_deleted     BOOLEAN                  NOT NULL
        );

        COMMENT ON TABLE aoa_user IS 'The table of user';

        COMMENT ON COLUMN aoa_user.id IS 'The id for the user and this is unique';
        COMMENT ON COLUMN aoa_user.name IS 'The user name';
        COMMENT ON COLUMN aoa_user.dob IS 'The user date of birth';
        COMMENT ON COLUMN aoa_user.phone_number IS 'The user phone number';
        COMMENT ON COLUMN aoa_user.personality_id IS 'The person ID in user country';
        COMMENT ON COLUMN aoa_user.created IS 'Time the user had been created in the table';
        COMMENT ON COLUMN aoa_user.modified IS 'Time the user had been modified in the table';
        COMMENT ON COLUMN aoa_user.created_by IS 'The user had been created by whom';
        COMMENT ON COLUMN aoa_user.modified_by IS 'The user had been modified by whom';
        COMMENT ON COLUMN aoa_user.is_deleted IS 'The user had been deleted or not';
    END
$$
