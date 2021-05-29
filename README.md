# Docker Instructions

# Vault

- docker run -d -p8200:8200 vault
- docker ps
- docker log <vault container id>
- docker exec -it <vault container id> /bin/sh
- export VAULT_ADDR="https://localhost:8200"

# Keycloak

- docker run -p 8787:8787 -e KEYCLOAK_USER=admin -e KEYCLOAK_PASSWORD=admin -e DB_VENDOR=H2 quay.io/keycloak/keycloak:13.0.0

# Keycloak Instruatcion
## Creating Realm
- Step 1 - Select Add Realm Option - https://www.keycloak.org/docs/6.0/server_admin/keycloak-images/add-realm-menu.png
- Step 2 - Save Realm - https://www.keycloak.org/docs/6.0/server_admin/keycloak-images/create-realm.png

## Creating Client 
- Step 1 - Move to Clients Tab - https://miro.medium.com/max/2690/1*rCXC710J13agnkdVNkM5ag.png
- Step 2 - Select Create Client - https://developers.redhat.com/sites/default/files/blog/2017/05/screen-shot-2016-12-12-at-10-29-35-pm.png
- Step 3 - Access Type - Confidential, Service Accounts Enabled - True
- Step 4 - Redirect URI - add redirect uri that we have mentioned in api-gateway api properties
- Step 5 - Copy Client Secrete - https://i.stack.imgur.com/HzR8X.png

## Add User
- Step 1 - Move to User Tab - https://www.keycloak.org/docs/latest/getting_started/images/add-user.png
- Step 2 - Set Password - https://www.keycloak.org/docs/5.0/server_admin/keycloak-images/user-credentials.png 

