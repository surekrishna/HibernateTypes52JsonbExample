SET search_path TO hrms_krish;

CREATE TABLE test (
    id bigint NOT NULL,
    cars jsonb NULL
);

ALTER TABLE test OWNER TO hrms;

CREATE SEQUENCE TEST_ID_GENERATOR
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE TEST_ID_GENERATOR OWNER TO hrms;