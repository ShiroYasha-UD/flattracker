create table listing (
    id bigserial primary key,
    external_id text not null unique,
    listing_type text not null check ( listing_type in ('RENT', 'SALE')),
    url text not null,
    district smallint not null check ( district between 1 and 23),
    size_m2 numeric(6,1) not null check (size_m2>0),
    first_seen_at timestamptz not null default now(),
    last_seen_at timestamptz not null  default now(),
    removed_at timestamptz
);

create table listing_price (
    id  bigserial primary key,
    listing_id bigint not null references listing (id) on delete cascade,
    price_huf bigint not null check ( price_huf > 0 ),
    active_from timestamptz not null default now(),
    active_to timestamptz,
    check ( active_to is null or active_to > active_from )
);

create unique index listing_price_one_current
    on listing_price (listing_id) where active_to is null;


create index listing_price_history
    on listing_price (listing_id, active_from);
