DROP TABLE public.exercise;

CREATE TABLE public.exercise
(
    id integer NOT NULL DEFAULT nextval('exercise_id_seq'::regclass),
    name character varying(100) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT exercise_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.exercise
    OWNER to postgres;