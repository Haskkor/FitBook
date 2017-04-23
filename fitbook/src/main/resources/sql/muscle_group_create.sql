DROP TABLE public.muscle_group;

CREATE TABLE public.muscle_group
(
    id integer NOT NULL DEFAULT nextval('muscle_group_id_seq'::regclass),
    name character varying(30) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT muscle_group_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.muscle_group
    OWNER to postgres;