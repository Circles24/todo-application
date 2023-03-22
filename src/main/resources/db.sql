--task table schema

create table `task` (
  `id` VARCHAR(255) not null,
  `description` varchar(255) not null,
  `status` varchar(255) not null default 'ACTIVE',
  `created_at` timestamp not null default CURRENT_TIMESTAMP,
  `updated_at` timestamp not null default CURRENT_TIMESTAMP,
  primary key (`id`)
);