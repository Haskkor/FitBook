DROP TABLE public.workout;

CREATE TABLE public.workout
(
    id integer NOT NULL DEFAULT nextval('workout_id_seq'::regclass),
    name character varying(50) COLLATE pg_catalog."default" NOT NULL,
    date_workout date NOT NULL,
    user_id integer NOT NULL,
    CONSTRAINT workout_pkey PRIMARY KEY (id),
    CONSTRAINT workout_user_id_fkey FOREIGN KEY (user_id)
        REFERENCES public.app_user (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.workout
    OWNER to postgres;