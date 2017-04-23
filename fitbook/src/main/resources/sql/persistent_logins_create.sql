DROP TABLE public.persistent_logins;

CREATE TABLE public.persistent_logins
(
    username character varying(64) COLLATE pg_catalog."default" NOT NULL,
    series character varying(64) COLLATE pg_catalog."default" NOT NULL,
    token character varying(64) COLLATE pg_catalog."default" NOT NULL,
    last_used timestamp without time zone NOT NULL,
    CONSTRAINT persistent_logins_pkey PRIMARY KEY (series)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.persistent_logins
    OWNER to postgres;