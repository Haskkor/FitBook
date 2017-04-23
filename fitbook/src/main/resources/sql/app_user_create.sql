DROP TABLE public.app_user;

CREATE TABLE public.app_user
(
    id integer NOT NULL DEFAULT nextval('app_user_id_seq'::regclass),
    sso_id character varying(30) COLLATE pg_catalog."default" NOT NULL,
    password character varying(100) COLLATE pg_catalog."default" NOT NULL,
    first_name character varying(30) COLLATE pg_catalog."default" NOT NULL,
    last_name character varying(30) COLLATE pg_catalog."default" NOT NULL,
    email character varying(30) COLLATE pg_catalog."default" NOT NULL,
    state character varying(30) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT app_user_pkey PRIMARY KEY (id),
    CONSTRAINT app_user_sso_id_key UNIQUE (sso_id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.app_user
    OWNER to postgres;