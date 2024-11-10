// seed.js

// courses
db.courses.insertMany([
    {
        _id: 'seed-id-1',
        name: 'seed-course-1',
        description: 'seed-description-1',
        createdDate: ISODate('2024-01-01T00:00:01.000Z'),
        lastModifiedDate: ISODate('2024-01-01T00:00:01.000Z'),
    },
    {
        _id: 'seed-id-2',
        name: 'seed-course-2',
        description: 'seed-description-2',
        createdDate: ISODate('2024-01-01T00:00:01.000Z'),
        lastModifiedDate: ISODate('2024-01-01T00:00:01.000Z'),
    },
    {
        _id: 'seed-id-3',
        name: 'seed-course-3',
        description: 'seed-description-3',
        createdDate: ISODate('2024-01-01T00:00:01.000Z'),
        lastModifiedDate: ISODate('2024-01-01T00:00:01.000Z'),
    }
]);