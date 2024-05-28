# No volume
#podman run -dt --name adopter -e POSTGRES_PASSWORD=password -e PAGER=/usr/bin/less -e LESS="-X -R -i" -p 5433:5432 docker.io/library/postgres

# load schema file with postgres user
type code\BackEnd\adoption\adoption\resources\schema.sql | podman exec -i adopter psql -Upostgres -d adoption
# type code\BackEnd\adoption\adoption\resources\data.sql | podman exec -i adopter psql -Upostgres -d adoption

# shell into container
# podman exec -ti 36 /bin/bash