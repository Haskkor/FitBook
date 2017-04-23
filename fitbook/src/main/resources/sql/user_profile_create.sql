DROP TABLE public.user_profile;

CREATE TABLE public.user_profile
(
    id integer NOT NULL DEFAULT nextval('user_profile_id_seq'::regclass),
    type character varying(30) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT user_profile_pkey PRIMARY KEY (id),
    CONSTRAINT user_profile_type_key UNIQUE (type)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.user_profile
    OWNER to postgres;