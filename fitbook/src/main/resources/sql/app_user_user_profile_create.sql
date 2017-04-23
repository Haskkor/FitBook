DROP TABLE public.app_user_user_profile;

CREATE TABLE public.app_user_user_profile
(
    user_id bigint NOT NULL,
    user_profile_id bigint NOT NULL,
    CONSTRAINT app_user_user_profile_pkey PRIMARY KEY (user_id, user_profile_id),
    CONSTRAINT fk_app_user FOREIGN KEY (user_id)
        REFERENCES public.app_user (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_user_profile FOREIGN KEY (user_profile_id)
        REFERENCES public.user_profile (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.app_user_user_profile
    OWNER to postgres;