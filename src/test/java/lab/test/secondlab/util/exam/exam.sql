------------------ Database Exam Answers ---------------


CREATE SCHEMA IF NOT EXISTS exam;

------------------ HOTEL ---------------

CREATE TABLE exam.hotel(
  hotelNo   SERIAL PRIMARY KEY,
  hotelName VARCHAR(128) NOT NULL UNIQUE,
  city      VARCHAR(128) NOT NULL
);

--- NOT UPDATABLE VIEW
CREATE VIEW exam.hotelFirstFiveView
  AS SELECT *
  FROM exam.hotel
  LIMIT 5;

------------------ ROOM ----------------

CREATE TYPE roomType AS ENUM ('single', 'double', 'family');

CREATE TABLE exam.room(
  hotelNo INT NOT NULL REFERENCES exam.hotel(hotelNo),
  roomNo  INT NOT NULL,
  type    roomType NOT NULL,
  price   INT NOT NULL,
  PRIMARY KEY(roomNo, hotelNo),
  CONSTRAINT priceRange   CHECK (price >= 10 AND price <= 100),
  CONSTRAINT roomNoRange  CHECK (roomNo >=1 AND roomNo <= 100)
);

--- NOT UPDATABLE VIEW
CREATE VIEW exam.roomView
  AS SELECT *
  FROM exam.room
  LIMIT 10;

------------------ GUESTS -------------------

CREATE TABLE exam.guests(
  guestNo      SERIAL PRIMARY KEY,
  guestName    VARCHAR(128) NOT NULL,
  guestAddress VARCHAR(255) NOT NULL
);

CREATE VIEW exam.guestsView
  AS SELECT *
  FROM exam.guests;

---------------- BOOKING --------------------

CREATE TABLE exam.booking(
  hotelNo   INT NOT NULL,
  roomNo    INT NOT NULL,
  guestNo   INT NOT NULL REFERENCES exam.guests(guestNo),
  dateFrom  TIMESTAMP NOT NULL DEFAULT now(),
  dateTo    TIMESTAMP NOT NULL,
  PRIMARY KEY (hotelNo, guestNo, dateFrom),
  FOREIGN KEY (hotelNo, roomNo) REFERENCES exam.room(hotelNo, roomNo),
  CONSTRAINT roomBookUnique UNIQUE (hotelNo, roomNo),
  CONSTRAINT dateCheck CHECK (dateFrom >= now() AND dateTo > dateFrom)
);

CREATE VIEW exam.bookingView
  AS SELECT *
  FROM exam.booking;

---------------- DATA ------------------------

INSERT INTO exam.guests(guestName, guestAddress)
VALUES ('Bob', 'Saint-Petesburg, 123, backer');
INSERT INTO exam.guests(guestName, guestAddress)
VALUES ('Tom', 'Kemerovo, 80, Kolovo');
INSERT INTO exam.guests(guestName, guestAddress)
VALUES ('Bill', 'Moskov, 536, Toivok');
INSERT INTO exam.guests(guestName, guestAddress)
VALUES ('Sara', 'Enesei, 24, Korovino');
INSERT INTO exam.guests(guestName, guestAddress)
VALUES ('Lilly', 'Kursk, 6, Rolof');


INSERT INTO exam.hotel(hotelName, city)
VALUES ('LaPary', 'Paris');
INSERT INTO exam.hotel(hotelName, city)
VALUES ('Deluxe', 'London');
INSERT INTO exam.hotel(hotelName, city)
VALUES ('Vialose', 'London');
INSERT INTO exam.hotel(hotelName, city)
VALUES ('Komsomol', 'Saint-Petersburg');


INSERT INTO exam.room(hotelNo, roomNo, type, price)
VALUES (1, 10, 'single', 70);
INSERT INTO exam.room(hotelNo, roomNo, type, price)
VALUES (1, 20, 'double', 20);
INSERT INTO exam.room(hotelNo, roomNo, type, price)
VALUES (1, 50, 'double', 50);
INSERT INTO exam.room(hotelNo, roomNo, type, price)
VALUES (2, 30, 'double', 30);
INSERT INTO exam.room(hotelNo, roomNo, type, price)
VALUES (2, 40, 'single', 40);
INSERT INTO exam.room(hotelNo, roomNo, type, price)
VALUES (2, 50, 'single', 40);
INSERT INTO exam.room(hotelNo, roomNo, type, price)
VALUES (3, 50, 'double', 50);
INSERT INTO exam.room(hotelNo, roomNo, type, price)
VALUES (3, 60, 'triple', 90);
INSERT INTO exam.room(hotelNo, roomNo, type, price)
VALUES (4, 70, 'triple', 70);


INSERT INTO exam.booking(hotelNo, roomNo, guestNo, dateTo)
VALUES (1, 10, 4, '2018-10-27 02:00:00');
INSERT INTO exam.booking(hotelNo, roomNo, guestNo, dateTo)
VALUES (1, 50, 1, '2018-12-7 02:00:00');
INSERT INTO exam.booking(hotelNo, roomNo, guestNo, dateTo)
VALUES (2, 30, 2, '2018-1-25 02:00:00');
INSERT INTO exam.booking(hotelNo, roomNo, guestNo, dateTo)
VALUES (2, 40, 3, '2018-6-17 02:00:00');
INSERT INTO exam.booking(hotelNo, roomNo, guestNo, dateTo)
VALUES (3, 50, 1, '2018-5-2 02:00:00');
INSERT INTO exam.booking(hotelNo, roomNo, guestNo, dateTo)
VALUES (3, 60, 5, '2018-5-2 02:00:00');
INSERT INTO exam.booking(hotelNo, roomNo, guestNo, dateTo)
VALUES (4, 70, 5, '2018-8-2 02:00:00');



--------------- QUERIES ----------------------

-- a
SELECT * FROM exam.hotel WHERE exam.hotel.city = 'London';


-- b
SELECT exam.guests.guestName, exam.guests.guestAddress
FROM exam.guests, exam.hotel, exam.booking
WHERE exam.guests.guestNo = exam.booking.guestNo AND exam.booking.hotelNo =
      (SELECT exam.hotel.hotelNo FROM exam.hotel WHERE city = 'London')
GROUP BY guestName, guestAddress
ORDER BY guestName;


SELECT exam.guests.guestName, exam.guests.guestAddress
FROM exam.guests, exam.booking,
  (
    SELECT exam.hotel.hotelNo
    FROM exam.hotel
    WHERE city = 'London'
  ) AS priorHotels
WHERE exam.guests.guestNo = exam.booking.guestNo AND exam.booking.hotelNo = priorHotels.hotelNo
GROUP BY guestName, guestAddress
ORDER BY guestName;

-- c
SELECT exam.room.roomNo, exam.room.hotelNo, exam.room.type, exam.room.price
FROM exam.room
WHERE exam.room.price < 40 AND (exam.room.type = 'triple' OR exam.room.type = 'double')
ORDER BY exam.room.price DESC;


-- d
SELECT exam.booking.roomNo, exam.booking.hotelNo, exam.booking.dateFrom
FROM exam.booking
WHERE exam.booking.dateTo IS NULL;


-- e
SELECT COUNT(DISTINCT exam.hotel.hotelNo), COUNT(exam.room.roomNo), AVG(exam.room.price)
FROM exam.hotel, exam.room
WHERE exam.hotel.city = 'London' AND exam.room.hotelNo = exam.hotel.hotelNo;


-- f
SELECT SUM(exam.room.price)
FROM exam.room, exam.booking
WHERE exam.room.type = 'double'
      AND exam.room.roomNo = exam.booking.roomNo
      AND exam.room.hotelNo = exam.booking.hotelNo;

SELECT SUM(exam.room.price)
FROM exam.room
WHERE exam.room.type = 'double';

-- g
SELECT COUNT(exam.guests.guestNo)
FROM exam.guests, exam.booking
WHERE date_part('month', exam.booking.dateFrom) = 8;


-- h
SELECT exam.room.roomNo, exam.room.type, exam.room.price
FROM exam.room
WHERE exam.room.hotelNo = 1;


-- i
SELECT exam.guests.guestName
FROM exam.guests,exam.booking
WHERE dateFrom < now() AND dateTo > now()
GROUP BY exam.guests.guestName;


-- j
SELECT exam.room.hotelNo, exam.room.roomNo, exam.room.type, exam.room.price, exam.guests.guestName
FROM exam.guests, exam.room,
  (
    SELECT exam.booking.hotelNo, exam.booking.roomNo, exam.booking.guestNo
    FROM exam.booking
    WHERE hotelNo = 1
  ) AS hotelRooms
WHERE room.hotelNo = hotelRooms.hotelNo
      AND room.roomNo = hotelRooms.roomNo
      AND guests.guestNo = hotelRooms.guestNo;


-- k
SELECT SUM(exam.room.price)
FROM exam.room
  JOIN exam.booking ON exam.booking.hotelNo = 3
WHERE exam.booking.hotelNo = exam.room.hotelNo
      AND exam.booking.roomNo = exam.room.roomNo;


SELECT SUM(exam.room.price)
FROM exam.room,
  (
    SELECT exam.booking.roomNo, exam.booking.hotelNo
    FROM exam.booking
    WHERE exam.booking.hotelNo = 3
  ) AS rooms
WHERE rooms.hotelNo = exam.room.hotelNo
      AND rooms.roomNo = exam.room.roomNo;


-- l
SELECT exam.room.roomNo, exam.room.price
FROM exam.room
WHERE exam.room.roomNo NOT IN
      (
        SELECT exam.booking.roomNo
        FROM exam.booking
        WHERE exam.booking.hotelNo = 2
      )
      AND exam.room.hotelNo = 2;


-- m
SELECT -SUM(exam.room.price) AS loss
FROM exam.room
WHERE exam.room.roomNo NOT IN
      (
        SELECT exam.booking.roomNo
        FROM exam.booking
        WHERE exam.booking.hotelNo = 2
      )
      AND exam.room.hotelNo = 2;


-- n
SELECT COUNT(exam.room.roomNo)
FROM exam.room,
  (
    SELECT exam.hotel.hotelNo
    FROM exam.hotel
    WHERE exam.hotel.city = 'London'
  ) AS priorHotels
WHERE exam.room.hotelNo = priorHotels.hotelNo;


-- o
SELECT exam.booking.hotelNo, COUNT(*) / COUNT(DISTINCT exam.booking.hotelNo) AS avgBooking
FROM exam.booking
WHERE
  (
    (exam.booking.dateFrom, exam.booking.dateTo)
      OVERLAPS
    (DATE '2017-08-01', INTERVAL '30 days')
  )
GROUP BY exam.booking.hotelNo;


-- p
SELECT h.hotelNo, r.type, COUNT(r.type) AS X
FROM exam.booking b, exam.hotel h, exam.room r
WHERE r.roomNo = b.roomNo
      AND b.hotelNo = h.hotelNo
      AND city = 'London'
GROUP BY type, h.hotelNo;


-- g
SELECT exam.room.hotelNo, -SUM(exam.room.price) AS loss
FROM exam.room
WHERE (exam.room.hotelNo, exam.room.roomNo) NOT IN
      (
        SELECT exam.booking.hotelNo, exam.booking.roomNo
        FROM exam.booking
      )
GROUP BY exam.room.hotelNo
ORDER BY loss;


-- r
INSERT INTO exam.guests(guestName, guestAddress)
VALUES ('Timaty', 'SuperMuperAddress');
INSERT INTO exam.booking(hotelNo, roomNo, guestNo, dateTo)
VALUES (4, 70, 5, '2018-08-12');

-- s
UPDATE exam.room
    SET price = coalesce(price, 0) + 5;



--------------------------- Определение данных 5 -----------------------

-- b
SELECT DISTINCT ON (exam.hotel.city) exam.hotel.hotelNo, exam.hotel.city, MIN(hotelPrice.price)
FROM exam.hotel,
  (
    SELECT
      exam.room.hotelNo,
      MIN(exam.room.price) AS price
    FROM exam.room, exam.hotel
    GROUP BY exam.room.hotelNo
    ) AS hotelPrice
WHERE exam.hotel.hotelNo = hotelPrice.hotelNo
GROUP BY exam.hotel.hotelNo;


-- c
GRANT ALL PRIVILEGES ON bazadannyh TO manager, director WITH GRANT OPTION;


-- d
CREATE VIEW HotelBookingCount (hoteINo, bookingCount)
AS SELECT exam.hotel.hotelNo, COUNT(*)
   FROM exam.hotel h, exam.room r, exam.booking b
   WHERE h.hotelNo = r.hotelNo AND r.roomNo = b.roomNo
GROUP BY h.hotelNo;


-- (a) SELECT * FROM HotelBookingCount;
SELECT h.hotelNo, COUNT(*)
FROM exam.hotel AS h, exam.room AS r, exam.booking AS b
WHERE h.hotelNo = r.hotelNo AND r.roomNo = b.roomNo
GROUP BY h.hotelNo;


-- (b) SELECT hoteINo FROM HotelBookingCount WHERE hoteINo =’H001’;
SELECT h.hotelNo
FROM exam.hotel AS h, exam.room AS r, exam.booking AS b
WHERE h.hotelNo = 1 AND r.roomNo = b.roomNo
GROUP BY h.hotelNo;

-- ??? defuck find hotel No with hotel No 'H001' ???

-- (c) SELECT MIN(bookingCount) FROM HotelBookingCount;
SELECT MIN(hotelBook.count)
FROM
  (
    SELECT h.hotelNo AS hotelNo, COUNT(*) AS count
    FROM exam.hotel AS h, exam.room AS r, exam.booking AS b
    WHERE h.hotelNo = r.hotelNo AND r.roomNo = b.roomNo
    GROUP BY h.hotelNo
) AS hotelBook;


-- (d) SELECT COUNT(*) FROM HotelBookingCount;
SELECT COUNT(*)
FROM
  (
    SELECT h.hotelNo AS hotelNo, COUNT(*) AS counter
    FROM exam.hotel AS h, exam.room AS r, exam.booking AS b
    WHERE h.hotelNo = r.hotelNo
          AND r.roomNo = b.roomNo
    GROUP BY h.hotelNo
  ) AS hotelBook;


-- (e) SELECT hoteINo FROM HotelBookingCount WHERE bookingCount > 1000;
SELECT hotelBook.hotelNo
FROM
  (
    SELECT h.hotelNo AS hotelNo, COUNT(*) AS counter
    FROM exam.hotel AS h, exam.room AS r, exam.booking AS b
    WHERE h.hotelNo = r.hotelNo
          AND r.roomNo = b.roomNo
    GROUP BY h.hotelNo
  ) AS hotelBook
WHERE hotelBook.counter > 3;


-- (f) SELECT hoteINo FROM HotelBookingCount ORDER BY bookingCount;
SELECT h.hotelNo AS hotelNo
FROM exam.hotel AS h, exam.room AS r, exam.booking AS b
WHERE h.hotelNo = r.hotelNo
    AND r.roomNo = b.roomNo
GROUP BY h.hotelNo
ORDER BY COUNT(*);
